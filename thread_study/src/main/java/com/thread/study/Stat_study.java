package com.thread.study;

public class Stat_study {
    
    int cnt=0;
    public int getCnt()
    {
        return cnt;
    }

    public synchronized void increment()
    {
        cnt++;
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
          
        }
    }
}

class Exam {
    public static void main(String[] args) throws InterruptedException {
        Stat_study st = new Stat_study();

        Thread thd = new Thread(() -> {
            long cnt = 0;
            while (cnt < 10) {
                try {
                    cnt++;
                    Thread.sleep(1000);
                } catch (Exception e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        System.out.println(thd.getState());
        thd.start();

        while (thd.isAlive()) {
            Thread.sleep(1000);
            System.out.println(thd.getState());
        }
    }
}
