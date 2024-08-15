package com.nat.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import java.util.Scanner;

public class Exam04 {
    
    public static void main(String[] args) {
        int port = 4030;
        try(ServerSocket serverSocket = new ServerSocket(port)) //포트 연결 대기중으로 변경
        {
            //TODO 클라이언트 accept부분에서 안넘어감
            System.out.println("클라이언트 연결중입니다..");

            Socket socket = serverSocket.accept(); //클라이언트 연결 요청을 수락함
            System.out.println("Connected : "+socket.getInetAddress().getHostAddress());

            Scanner sc = new Scanner(System.in);
            System.out.println("보낼 메세지를 입력해주세요");
            String msgStr = sc.nextLine();

            if(msgStr.equals("exit"))
            {
                socket.close();
            }
            try{
                socket.getOutputStream().write(msgStr.getBytes());
                socket.getOutputStream().flush(); 
                //OutputStream의 버퍼를 비우고 모든 데이터를 출력 스트림에 즉시 사용
                
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String response = reader.readLine();
                System.out.println("클라이언트 응답: " + response);
            }catch(IOException e){
                System.err.println("전송 중 오류발생했습니다 : "+e.getMessage());
            }finally{socket.close(); //소켓닫기
            sc.close();
            }
        }catch(IOException e)
        {
            System.err.println("서버 오류: " + e.getMessage());
        }
    }
}
