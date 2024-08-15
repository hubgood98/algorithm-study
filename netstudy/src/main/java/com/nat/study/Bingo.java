package com.nat.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Bingo implements Runnable{

    String[][] table; //빙고판 미구현..
    Bingo(int a, int b)
    {
        System.out.printf("빙고 게임판 %dx%d 사이즈로 생성했습니다.",a,b);
        table = new String[a][b];
    }

    void setTable(int val)
    {

    }
    public static void main(String[] args) {
     
    
    }

    @Override
    public void run() {
        int count = 10;

        for (int i = count; i > 0; i--) {
            System.out.println("남은 시간 : "+i+"초");
        }
    }
    
}
