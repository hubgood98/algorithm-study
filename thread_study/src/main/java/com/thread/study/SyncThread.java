package com.thread.study;

class ThreadDeadlock {
    public static void main(String[] args) {
        Object obj1 = new Object();
        Object obj2 = new Object();
        Object obj3 = new Object();

        startThread(new SyncThread(obj1, obj2), "t1");
        startThread(new SyncThread(obj2, obj3), "t2");
        startThread(new SyncThread(obj3, obj1), "t3");
    }

    private static void startThread(Runnable runnable, String threadName) {
        Thread thread = new Thread(runnable, threadName);
        thread.start();
    }
}

public class SyncThread implements Runnable {
    private final Object obj1;
    private final Object obj2;

    public SyncThread(Object o1, Object o2) {
        this.obj1 = o1;
        this.obj2 = o2;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        synchronized (obj1) {
            System.out.println(name + " acquired lock on " + obj1);
            work();
            synchronized (obj2) {
                System.out.println(name + " acquired lock on " + obj2);
                work();
            }
            System.out.println(name + " released lock on " + obj2);
        }
        System.out.println(name + " released lock on " + obj1);
        System.out.println(name + " finished execution.");
    
    }

    private void work() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
