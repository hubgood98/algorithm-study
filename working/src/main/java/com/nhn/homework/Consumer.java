package com.nhn.homework;

import java.util.concurrent.ThreadLocalRandom;

public class Consumer implements Runnable {

    String name; // 소비자 이름
    Store store; // 매장

    public Consumer(String name, Store store) {
        this.name = name;
        this.store = store; 
    }

    @Override
    public void run() {
        // 매장 입장
        synchronized (store) {
            while (store.getEnter() >= store.getMaxEnter()) {  //현재인원 비교
                try {
                    System.out.println(name + "님이 입장 대기중 입니다....");
                    store.wait(); // 매장 입장대기   
                } 
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(name + "님이 매장에 입장하였습니다.");
            store.enter();
            System.out.println("현재 " + store.getstoreName() + " 매장 입장 인원 수 " + store.getEnter() + "명\n");
        }

        // 물건 구매
        while (store.getobj() > 0) {
            store.buy(name);
            try {
                int interval = ThreadLocalRandom.current().nextInt(3, 11); 
                Thread.sleep(interval * 1000);
                break;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // 매장 퇴장
        synchronized (store) {
            store.exit();
            System.out.println("[알림] "+name + "님이 퇴장하였습니다. 현재 남은인원: " + store.getEnter()+"\n");
            store.notify(); // 대기 중인 다른 소비자에게 알림, 매장 입장 기회 제공
        }
    }
}
