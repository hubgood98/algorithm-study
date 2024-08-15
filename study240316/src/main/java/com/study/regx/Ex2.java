package com.study.regx;

import org.json.JSONException;
import org.json.JSONObject;

public class Ex2 {
    public static void main(String[] args) {
        String jsonString = "{\"address : 555}";
        try {
            JSONObject object = new JSONObject(jsonString);

            System.out.println(object.toString()); 
        } 
        catch (JSONException e) {
            System.err.println(e);
        }
   
    }
}

class Person{
    String name;
    int age;

    public Person(String name,int age) {
        this.name = name;
        this.age = age;
    }

    public String getName()
    {
        return name;
    }

    public int getAge()
    {
        return age;
    }

    public void setName(String name)
    {
        this.name = name;
    }
    public static void main(String[] args) {
        Person person = new Person("KHJ",27);
        JSONObject object = new JSONObject();

        try {
            object.put("이름",person.getName());
            object.put("나이", person.getAge());
            System.out.println(object);
        } catch (JSONException e) {
            System.err.println("현재 발생된 오류 : "+e);
        }

        
    }
}