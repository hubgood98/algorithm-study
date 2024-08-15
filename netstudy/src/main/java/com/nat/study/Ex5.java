package com.nat.study;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Ex5 {
     //클라이언트에서 콘솔로 보내기
    static Socket socket;
    public static void main(String[] args) {
        String host = "localhost"; //리눅스 커널창으로 nc -l 1234 포트 열어주기
        int port = 1234;
        Scanner sc = new Scanner(System.in);
        try 
        {
            socket = new Socket(host,port);
            System.out.println("연결되었습니다.");
        } catch (Exception e) {
            System.err.println(host + ":" + port + "에 연결할 수 없습니다.");
        }
        while(true)
        {
            String line = sc.nextLine();
            if(line.equals("exit"))
            {
                break;
            }
            else
            {
                try {
                    line += "\n";
                    socket.getOutputStream().write(line.getBytes());
                } catch (IOException e) {
                   System.err.println(e.getMessage());                   
                } 
            }
        }    
    }
}
