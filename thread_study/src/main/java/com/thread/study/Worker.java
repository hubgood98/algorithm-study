package com.thread.study;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Worker implements Runnable {
    String name;

    public Worker(String name)
    {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void run() {
        System.out.println(getName()+" 작업 시작함"+ Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        System.out.println(getName()+" 완료");
    }

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(5); //쓰레드는 최대 5개생성하기

        for (int i = 0; i < 10; i++) {
            executor.submit(new Worker("Worker"+i)); //Runnable로 10개 호ㅜ
        }

        // 모든 작업이 완료될 때까지 대기
        executor.shutdown();
        while (!executor.isTerminated()) { }

        System.out.println("모든 작업이 완료되었습니다.");

    }
}
