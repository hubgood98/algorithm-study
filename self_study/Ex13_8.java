
public class Ex13_8 implements Runnable{
    static boolean autoSave = false;
    public static void main(String[] args) {

        Thread t = new Thread(new Ex13_8());

        t.setDaemon(true);
        t.start();
       
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);

            } catch (Exception e) {
                // TODO: handle exception
            }System.out.println(i);
            if(i==5)autoSave = true;
        }
        System.out.println("프로그램 종료합니다");
    }

    @Override
    public void run() {
        while (true) {
           try {
            Thread.sleep(3*1000);
           } catch (Exception e) {}
            if(autoSave) autoSave();
           
        }
    }

    void autoSave()
    {
        System.out.println("작업파일 저장");
    }
}
