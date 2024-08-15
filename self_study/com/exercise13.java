package com;

public class exercise13 {
    public static void main(String[] args) {
        Thread2 t1 = new Thread2();
        Thread t2 =new Thread(new Thread2());
        t1.start();

        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
    }
}

class Thread2 extends Thread{
    @Override
    public void run() {
        for (int i = 10; i < 20; i++) {
            System.out.println(i);
        }
    }
}
