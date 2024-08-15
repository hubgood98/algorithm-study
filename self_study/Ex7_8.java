
import java.util.Scanner;

class Product{
int price;
int BonusPoint;

    public Product(int price)
    {
        this.price = price;
        BonusPoint = (int) (price/10.0); //제품가격의 10%
    }

}
class Phone extends Product{
    Phone()
    {
        super(1400);
    }
    public String toString()
    {return "핸드폰";}
    
}
class Play extends Product{
    Play()
    {
        super(3600);
    }
    public String toString()
    {return "기부";}
    
}


class Computer extends Product{
    Computer()
    {
        super(800);
    }
    public String toString()
    {return "컴퓨터";}
    
}

class Buyer
{
    int money = 10000;
    int BonusPoint = 0;
    int index = 0;

    void buy(Product p)
    {
        if(money < p.price)
        {
            System.out.println("오류 : 잔액 부족");
            return;
        }
        else
        {
            money-=p.price;
            BonusPoint+=p.BonusPoint;
            System.out.println(p+"을/를 구입하셨습니다.");
        }
    }

}


public class Ex7_8 {

    public static void main(String[] args) {
        Buyer b = new Buyer();
        Scanner sc = new Scanner(System.in);
        while(true)
        {
            System.out.printf("현재 소지금액 %d원 , 포인트 %d",b.money,b.BonusPoint);
            System.out.println();
            String s = sc.nextLine();
            if(s.equals("Computer"))
            {
                b.buy(new Computer());
            }        
            else if(s.equals("Phone"))
                b.buy(new Phone());
            else if(s.equals("Play"))
                b.buy(new Play());
            else if(s.equals("exit"))
                break;
            else
                System.out.println("다시 입력해 주세요");
            
        }
        System.out.println("현재 남은 돈은"+b.money+"원입니다.");
        System.out.println("현재 보너스포인트 "+b.BonusPoint+"점");

    
}
}
