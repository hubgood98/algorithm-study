package com.thread.study;

public class Counter {
    int Count=0;
    int MaxCount;
    String name;
    Long startTime = System.currentTimeMillis();

    Counter(String name,int MaxCount)
    {
        this.name = name;
        this.MaxCount = MaxCount;
        Count = 0;
    }

    public void run()
    {
        while(Count<MaxCount)
        {
            try {
                Thread.sleep(1000);
                Count++;
                System.out.println(name + " : "+Count);

            } 
            catch (Exception e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static void main(String[] args) {

    ThreadCounter ct2 = new ThreadCounter("멀티 1", 8);
    ThreadCounter ct3 = new ThreadCounter("멀티 2", 8);
       ct2.start();
       ct3.start();

       
    }
}

class ThreadCounter extends Thread
{
    private String name;
    private int MaxCount;
    private int Count;

    ThreadCounter(String name,int MaxCount)
    {
        this.name = name;
        this.MaxCount = MaxCount;
        Count = 0;
    }

    @Override
    public void run()
    {
        while(Count<MaxCount)
        {
            try {
                Thread.sleep(1000);
                Count++;
                System.out.println(name + " : "+Count);

            } 
            catch (Exception e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println(name+"쓰레드 작업 소요시간" );
    }
    
}
