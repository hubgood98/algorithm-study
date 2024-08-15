package com.thread.study;

public class Priority {
    public static void main(String[] args) {
        Thread1 t1 = new Thread1();
        Thread2 t2 = new Thread2();
    
       t2.setPriority(9); //우선순위값이 높을수록 먼저 끝날 가능성이 높다

        System.out.println("t1 우선순위 "+t1.getPriority());
        System.out.println("t2 우선순위 "+t2.getPriority());
 
        t1.start();
        t2.start();
    }
   
    
}

class Thread1 extends Thread{
    public void run()
    {
        for (int i = 0; i < 300; i++) {
            System.out.print("-");
            for(int x=0;x<10000000;x++);
        }
    }
}

class Thread2 extends Thread{
    public void run()
    {
        for (int i = 0; i < 300; i++) {
            System.out.print("|");
            for(int x=0;x<10000000;x++); 
        }
    }
}