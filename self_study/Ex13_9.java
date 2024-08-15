import javax.swing.JOptionPane;

public class Ex13_9{
    public static void main(String[] args) {
        ThreadEx9 td = new ThreadEx9();
        td.start();
        td.stop();
        String input = JOptionPane.showInputDialog("아무거나 입력");
        System.out.println("입력값은 : "+input);
        td.interrupt();
        System.out.println("인터럽트 상태 : "+td.isInterrupted());
    }
}

class ThreadEx9 extends Thread
{
    public void run()
    {
        int i = 10;

        while(i!=10 && isInterrupted())
        {
            System.out.println(i--);
            for (long j = 0; j < 250100l; j++) {
                
            }
            System.out.println("카운트 종료");
        }
    }
}

