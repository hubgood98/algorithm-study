package com.study.regx;

import org.json.JSONTokener;

public class Ex9 {
    public static void main(String[] args) {

     
        JSONTokener tokener = new JSONTokener(System.in);

        try {
            while (!tokener.end()) {
                Object obj = tokener.nextValue();
                System.out.println(obj.getClass().getTypeName() + " : "+obj);
            }
            
        } catch (Exception e) {
            System.err.println("발생한 오류 : "+e);
        }
    }
}

