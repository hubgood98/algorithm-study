package com.thread.study;

public class SharedCount {
    int cnt;

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int count) {
        this.cnt = count;
    }

    public void increment() {
        synchronized(this){}
    }
}

    class SharedCounter extends Thread {
        SharedCount sharedCount;
        int count;
        int maxCount;
    
        public SharedCounter(String name, int maxCount, SharedCount sharedCount) {
            setName(name);
            this.sharedCount = sharedCount;
            this.maxCount = maxCount;
            count = 0;
        }
    
        @Override
        public void run() {
            while (count < maxCount) {
                count++;
                sharedCount.increment();
            }
        }
    }

   class Exam01 {
    
        public static void main(String[] args) throws InterruptedException{
            SharedCount sc = new SharedCount();
            SharedCounter counter1 = new SharedCounter("counter1", 10000, sc);
            SharedCounter counter2 = new SharedCounter("counter2", 10000, sc);
    
            counter1.start();
            counter2.start();
            System.out.println(counter1.getName() + ": "+counter1.getState());
            System.out.println(counter2.getName() + ": "+counter2.getState());
    
            counter1.join();
            counter2.join();
            System.out.println(counter1.getName() + ": "+counter1.getState());
            System.out.println(counter2.getName() + ": "+counter2.getState());
    
            System.out.println("sharedCount : " + sc.getCnt());
        }
    }

    