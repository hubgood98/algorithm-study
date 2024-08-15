package com;

public class Ex14{
    public static void main(String[] args) {
       
    MyFunction a = () -> {System.out.println("ㅎㅇ");};

    B b = (str) -> {};
    C c = () -> {return "반환값";}; //C는 타입이 존재하기에 return을 넣어줘야함

    D d = (x,y) -> {
        return x+y;
    };

    }
    

}
