package com.nat.study;

import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;


public class Ex3 {
    public static void main(String[] args) {
        String host = "localhost";
        int port = 1234;

        //TODO : 왜 혼자서 서버가 끊기는건지?
         try(Socket socket = new Socket(host,port))
         {System.out.println("서버에 연결되었습니다.");
         socket.getOutputStream().write("Oh hello?".getBytes()); //byte array가 나옴
         socket.getOutputStream().write("how are you today".getBytes()); //byte array가 나옴      
            }catch (Exception e) {
                System.err.println(host + ":" + port + "에 연결할 수 없습니다.");
        }   
    }
}
