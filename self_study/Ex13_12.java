
public class Ex13_12 {
    public static void main(String[] args) {
        Runnable r = new RunnableEx12(); 
        new Thread(r).start();
        new Thread(r).start();
        }
    }

    class Account{
        private int balance = 1000;

        public int getBalance(){
            return balance;
        }

        public synchronized void withdraw(int money) //싱크로나이즈를 사용하면 메서드 하나가 들어올때 잠금된다.
        {
            if(balance>=money)
            {
                try {
                    Thread.sleep(1000);
                } catch (Exception e) { }
                balance-= money;
            }
        }
    }

    class RunnableEx12 implements Runnable
    {
        Account acc = new Account();

        @Override
        public void run() {
            while(acc.getBalance()>0)
           {
            int money = (int)(Math.random() * 3 +1) *100;
            acc.withdraw(money);
            System.out.println("balance : "+acc.getBalance());
        }
        }
    }
