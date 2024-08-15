package com.nhnacademy;

import java.util.logging.Logger;

import org.apache.logging.log4j.core.tools.picocli.CommandLine.Parameters;

public class Rational {
    //
    @Parameters  //분자
    int bunja;
    int bunmo;

    // String을 기준으로 Logger 클래스 인스턴스 할당함
    Logger logger = Logger.getLogger("mylogger");
    

    public Rational()
    {
        
    }

    public Rational(int n)
    {
        bunja = n;
        bunmo = 1;


    }

    public Rational(int i,int j) //분수 i/j와 같음
    {
        if(j == 0)
        { throw new ArithmeticException();}
           
        if(j < 0)
        {
            i *= -1;
            j *= -1;
        }

        int g = gcd(Math.abs(i),Math.abs(j));

        this.bunja = i/g;
        this.bunmo = j/g;
    }

    public Rational(Rational other)
    {
        this.bunja = other.getBunja(); //필드값이 아닌 계산값에서 나와야 할 때가 있기에 
        this.bunmo = other.getBunmo();

    }

    public int gcd(int x, int y) //최대 공약수 구하기
    {
        if((x <= 0) || (y < 0))
        {throw new ArithmeticException();}
    
        if(y==0)
        {
            return x;
        }
        return gcd(y,x%y);
    }
    int getBunja()
    {
        return bunja;
    }

    int getBunmo()
    {
        return bunmo;
    }

    public int[] bunsuGOP(int[] bunsu1, int[] bunsu2)
    {
        bunja = bunsu1[0] * bunsu2[0];
        bunmo = bunsu1[1] * bunsu2[1];
        
        if(bunja%bunmo == 0)
        {
            bunja/=bunmo;
            bunmo/=bunmo; 
        }

        int[] bunsu = {bunja,bunmo};

        return bunsu;
    }



    public String toString()
    {
        if(getBunmo() ==1 )
        {
            return "["+getBunja()+"]";
        }
        else{
            return "["+getBunja()+"/"+getBunmo()+"]";
        }
    }

    @Override
    public boolean equals(Object other)
    {
        return (other instanceof Rational) 
        && (getBunja() == ((Rational) other).getBunmo())
        && (getBunja() == ((Rational) other).getBunja());
    }


    public static Rational add(Rational x, Rational y)
    {
        return new Rational(x.getBunja() * y.getBunmo() + x.getBunmo() * y.getBunja(), 
        x.getBunmo() * y.getBunmo());
    }

    public static Rational subtract(Rational x, Rational y)
    {
        return new Rational(x.getBunja() * y.getBunmo() - x.getBunmo() * y.getBunja(), 
        x.getBunmo() * y.getBunmo());
    }
    
    public Rational inverse()
    {
        return new Rational(-getBunja(),getBunmo());
    }

    public Rational reciprocal()
    {
        return new Rational(getBunmo(),getBunja());
    }


    public static void main(String[] args) {

        try{
            Rational r1 = new Rational(3,8);
            Rational r2 = new Rational(1,5);

            Rational result = Rational.add(r1, r2); //클래스 객체를 별도로 만들어서 호출해야 안전하다.

            System.out.println(r1 + " + " + r2 +" = "+ result);
            System.out.println(r1 + " - " + r2 +" = "+ Rational.subtract(r1, r2));
            /*System.out.println("add : " + r1.add(r1, r2)); */ //잘못된 코드

        


        }catch(ArithmeticException e)
        {System.err.println(e.getMessage());}


      
    }
}
