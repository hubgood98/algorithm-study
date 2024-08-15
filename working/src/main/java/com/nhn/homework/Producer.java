package com.nhn.homework;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Producer implements Runnable {
    Store store;
    Random ran;

    public Producer(Store store) {
        this.store = store;
    }

    public void run() {
        while (true) {
            try {
                // 1~10초 간격으로 물건을 채우기
                int ranMulgun = ThreadLocalRandom.current().nextInt(1, 11);
                Thread.sleep(ranMulgun * 1000);
    
                synchronized (store) {
                    if (store.getobj() >= store.getmaxobj()) {
                        System.out.println("[ 알바생 ] : 휴.. 드디어 물건 다 채웠네..");
                        break;
                    }
                    
                    // 소비자에게 매장이 물건을 추가했음을 알림
                    System.out.println("[ 알바생 ] : 영챠 (물건추가)");
                    store.supply();
                    store.notifyAll(); // 모든 대기 중인 소비자에게 알림
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}
