package com.nat.study;
import java.io.*;
import java.net.*;
import java.text.*;
import java.util.*;


public class Server {
    private ServerSocket serverSocket;
    private List<ClientHandler> clients;

    public Server(int port) {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println(getTime() + " 서버 연결 대기중...");
            clients = new ArrayList<>();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        try {
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println(getTime() + " 클라이언트가 연결되었습니다.");

                // 클라이언트를 처리하는 핸들러 생성
                ClientHandler clientHandler = new ClientHandler(clientSocket,clients);
                clients.add(clientHandler); // 클라이언트 리스트에 추가

                // 클라이언트 핸들러를 쓰레드로 실행
                Thread clientThread = new Thread(clientHandler);
                clientThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void removeClientHandler(ClientHandler clientHandler) {
        clients.remove(clientHandler);
    }

    public static String getTime() {
        SimpleDateFormat f = new SimpleDateFormat("[hh:mm:ss]");
        return f.format(new Date());
    }

    public static void main(String[] args) {
        int port = 1234;
        Server server = new Server(port);
        server.start();
    }
}
