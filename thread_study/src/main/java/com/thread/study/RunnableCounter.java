package com.thread.study;

public class RunnableCounter implements Runnable{
    int cnt;
    int maxCount;
    String name;
    Long startTime = System.currentTimeMillis();
    Thread trd;

    RunnableCounter(ThreadGroup group, String name,int maxCount)
    {

        this.name = name;
        cnt = maxCount;
        cnt = 0;
        trd = new Thread(group, this, name);
    }

    public int getCount()
    {
        return cnt;
    }

    public void run() //Start를 통해서 우선적으로 실행함
    {
        while(!Thread.currentThread().isInterrupted() && cnt<maxCount) //현재 스레드의 인터럽트가 발생하지 않았을 경우
        {
            try {
                Thread.sleep(1000);
                cnt++;
                System.out.println(name + " : "+cnt);

            } 
            catch (Exception e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public void start() {
        trd.start(); // 스레드 실행 시작
    }
    

}

class testo extends Thread{ 
    public static void main(String[] args) throws InterruptedException {

    ThreadGroup group = new ThreadGroup("그룹"); //일괄 제어를 위한 ThreadGroup object를 생성

    RunnableCounter thread1 = new RunnableCounter(group, "worker1", 100);
    RunnableCounter thread2 = new RunnableCounter(group, "worker2", 100);

    //thread1.setDaemon(true);

    thread1.start();
    thread2.start();

    Thread.sleep(5000); //5초
    group.interrupt(); //인터럽트 발생
    }
}