import java.util.ArrayList;
import java.util.Collections;

public class PockerCard2_27 {

  public static void main(String[] args) {

    Deck deck = new Deck();
    deck.shuffle();
    
    Player p1 = new Player("김희준"); 
    Player p2 = new Player("게스트"); 
    
    //5장을 갖고 시작
    for (int i = 0; i < 5; i++) 
    {
        p1.getCard(deck.deal());
        p2.getCard(deck.deal());
    }
    p1.showCard();
    p2.showCard();
    
    System.out.println(p1.name+"님 " + p1.getHand());
    System.out.println(p2.name+"님 " + p2.getHand());

  }
}

//카드 정보를 저장하는곳
class Card
{
  String number; //숫자
  String shape; //모양
  
  public Card(String number,String shape)
  {
    this.number = number;
    this.shape = shape;
  }
  
  @Override
  public String toString()
  {
    return shape+", "+number;
  }
}

//플레이어 정보를 저장하는곳
class Player
{
  String name;
  
  ArrayList<Card> my_deck = new ArrayList<Card>();
  
  public Player(String name)
  {
    this.name = name;
  }
  
  public void getCard(Card card)
  {
    this.my_deck.add(card);
  }
  
  public void showCard()
  {
    System.out.println(my_deck.toString());
  }

  //내 덱에 있는 카드가 족보 조건에 합한지 확인
  public String getHand() {
    ArrayList<String> numbers = new ArrayList<>();
    for (Card card : my_deck) {
        numbers.add(card.number);
    }

    //정렬해서 하나씩 까보기
    Collections.sort(numbers);

    boolean OnePair = false;
    boolean TwoPair = false;
    String PairCard = null;
    String twoPairCard = null;


    for (int i = 0; i < numbers.size() - 1; i++) {
        if (numbers.get(i).equals(numbers.get(i + 1))) 
        {
            if (OnePair) { //페어가 하나 더 나올때
                TwoPair = true;
                twoPairCard = numbers.get(i);
            } 
            else //동일한 num이 나올떄 
            {
                OnePair = true; //페어 true
                PairCard = numbers.get(i);
            }
        }
    }

    if (TwoPair) 
    {
        return "("+PairCard + ", " + twoPairCard+") 투페어";
    } else if (OnePair) 
    {
        return "("+ PairCard+") 원페어" ;
    } else 
        {return "탑";}
      
}
  

}

class Deck
{
  ArrayList<Card> deck = new ArrayList<Card>();
  
  String[] shape = {"CLUB", "DIAMOND", "HEART", "SPADE"};
  String[] number = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
  
  //기본 생성자를 통해서 모든 카드를 ArrayList배열에 담음
  public Deck() { 
    for(int i = 0; i < shape.length; i++)
    {
      for(int j = 0; j < number.length; j++)
        deck.add(new Card(number[j],shape[i]));
    }

  }
  
  public void shuffle() {
    Collections.shuffle(deck);
  }
  
  public Card deal()
  {
    return deck.remove(0);
  }
  
}