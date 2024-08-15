package com.nhn.homework;


public class Market {
    public static void main(String[] args) {

        // 매장 생성
        Store LG = new Store("LG",3);

        // 생산자와 소비자 생성
        Producer producer = new Producer(LG);
        
        Consumer con1 = new Consumer("레몬", LG);
        Consumer con2 = new Consumer("딸기", LG);
        Consumer con3 = new Consumer("김희준", LG);
        Consumer con4 = new Consumer("이씨", LG);
        //Consumer con5 = new Consumer("오렌지", LG);
        //Consumer con6 = new Consumer("한라봉", LG);
        //Consumer con7 = new Consumer("머스탱", LG);
        //Consumer con8 = new Consumer("복숭아", LG);
        //Consumer con9 = new Consumer("이슬", LG);
     

        // 생산자와 소비자 스레드 시작
        Thread producerThread = new Thread(producer);
        Thread consumerThread1 = new Thread(con1);
        Thread consumerThread2 = new Thread(con2);
        Thread consumerThread3 = new Thread(con3);
        Thread consumerThread4 = new Thread(con4);
        //Thread consumerThread5 = new Thread(con5);
        //Thread consumerThread6 = new Thread(con6);
        //Thread consumerThread7 = new Thread(con7);
        //Thread consumerThread8 = new Thread(con8);
        //Thread consumerThread9 = new Thread(con9);


        producerThread.start();
        consumerThread1.start();
        consumerThread2.start();
        consumerThread3.start();
        consumerThread4.start();
        //consumerThread5.start();
        //consumerThread6.start();
        //consumerThread7.start();
        //consumerThread8.start();
        //consumerThread9.start();

    }
}
