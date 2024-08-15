import javax.swing.JOptionPane;

public class Ex13_10 {
    static long startTime= 0;
    public static void main(String[] args) {
        
      The1 t1 = new The1();
      The2 t2 = new The2();
       t1.start();
       t2.start();
       startTime = System.currentTimeMillis();

       try {
         t1.yield(); //작업이 끝날때까지 기다림
         t2.join();
       } catch (Exception e) {
        // TODO: handle exception
       }
       System.out.print("소요시간:"+(System.currentTimeMillis() - startTime));
    }
}

class The1 extends Thread{
    int a = 300;
    @Override
    public void run() {
        for (int i = 0; i <a; i++) {
            System.out.print(new String("-"));
        }
    }
}

class The2 extends Thread{
    int a = 300;
    @Override
    public void run() {
        for (int i = 0; i <a; i++) {
            System.out.print(new String("|"));
        }
    }
} /// A 65   -> a 97     32

// A+32 = a