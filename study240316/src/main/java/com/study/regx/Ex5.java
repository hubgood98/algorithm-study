package com.study.regx;

import org.json.JSONObject;

public class Ex5 {
    public static void main(String[] args) {
        JSONObject customer = new JSONObject();
        customer.put("name","김희준");
        customer.put("age", 27);
        System.out.println(customer);

        Object name = customer.get("name");
        Object age = customer.get("age");

        System.out.println(name.getClass().getTypeName());
        System.out.println(age.getClass().getTypeName());

        System.out.println(name);
        System.out.println(age);
      
    }
}
