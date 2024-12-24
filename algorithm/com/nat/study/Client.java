package com.nat.study;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client implements Runnable {
    private String name;
    private String serverIp;
    private int port;
    private BufferedReader in;
    private BufferedWriter out;
    private Scanner sc;

    public Client(String serverIp, int port) {
        this.serverIp = serverIp;
        this.port = port;
        this.sc = new Scanner(System.in);
    }

    @Override
    public void run() {
        try {
            Socket socket = new Socket(serverIp, port);
            System.out.println("서버에 연결되었습니다.");

            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            // 서버로부터 닉네임 설정 요청을 받음
            System.out.println("닉네임을 입력하세요: ");
            name = sc.nextLine();

            // 서버에 닉네임 전송
            out.write(name + "\n");
            out.flush();

            // 서버에서 메시지 수신 및 출력
            Thread receiveThread = new Thread(() -> {
                try {
                    String receivedMsg;
                    while ((receivedMsg = in.readLine()) != null) {
                        System.out.println(receivedMsg);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            receiveThread.start();

            // 사용자 입력을 받아서 서버로 전송
            String outMsg;
            while (true) {
                outMsg = sc.nextLine();
                out.write("["+name+"] " +outMsg+"\n");
                out.flush();

                // "exit" 입력 시 채팅 종료
                if (outMsg.equals("exit")) {
                    System.out.println("채팅을 종료합니다.");
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                sc.close();
                out.close();
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        String serverIp = "127.0.0.1";
        int port = 1234;
        Client client = new Client(serverIp, port);
        Thread clientThread = new Thread(client);
        clientThread.start();
    }
}
