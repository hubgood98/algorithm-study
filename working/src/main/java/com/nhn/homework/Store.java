package com.nhn.homework;

import java.util.concurrent.Semaphore;

public class Store extends Thread{
    private String storeName;
    private int obj = 5; // 현재 전시된 품목 개수
    private final int maxobj; // 최대 물건 전시 가능 개수
    private int Enter = 0; //현재 입장인원
    private static final int MaxEnter = 5; // 최대 입장 가능 인원

    private final Semaphore itemSema; // 아이템 세마포어
    private final Semaphore enterSema; // 입장 세마포어


    public Store(String name,int maxobj) {
        this.storeName = name;
        this.maxobj = maxobj;
        this.itemSema = new Semaphore(maxobj, true); // 최대 아이템 개수로 세마포어 초기화
        this.enterSema = new Semaphore(MaxEnter, true); // 최대 입장 가능 인원으로 세마포어 초기화
   
    }


    public void enter() {
        try {
            synchronized (this) {
                Enter++;
                enterSema.acquire(); //사람수 세마포어 획득
            }
            
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void exit() {
        synchronized(this)
        {
            if (Enter > 0) {
                --Enter;
                enterSema.release(); //입구 세마포어 해제
            } else {
                System.out.println("퇴장할 인원이 없습니다.");
            }
        }
    }

    public void buy(String Name) {
        try {
            itemSema.acquire();//획득
            synchronized(this)
            {
                while (obj == 0) {
                    System.out.println(Name + "님이 물건이 없어서 대기중입니다...");
                    wait(); //대기
                }
                sell(Name);
            }
        }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    public void sell(String name) {
        synchronized(this)
        {
            if (obj > 0) {
                obj--;
                System.out.println(name+ "님 물건 구매완료! 현재 남은 재고 : " + obj);
              
            } else {
                System.out.println("판매할 물건이 없습니다.");
            }
            notifyAll(); // 물건을 판매했으므로 정지된 객체에게 알림
            itemSema.release(); 
        }
    }

    public void supply() {
        synchronized(this)
        {
            if (obj + 1 <= maxobj) {
                obj++;
                System.out.println("매장에 물건을 추가했습니다. 현재 물건 개수: " + obj);
            } else {
                System.out.println("매장에 추가할 수 있는 물건 개수를 초과했습니다.");
            }
            notifyAll(); // 대기 중인 모든 소비자에게 매장이 물건을 추가했음을 알림
        }
    }
    
   
    public int getEnter()
    {
        return Enter;
    }
    public int getMaxEnter() 
    {
        return MaxEnter;
    }
    public int getobj() 
    {
        return obj;
    }
    public int getmaxobj() 
    {
        return maxobj;
    }
    public String getstoreName() 
    {
        return storeName;
    }
}