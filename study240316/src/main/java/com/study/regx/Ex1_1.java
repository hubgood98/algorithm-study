package com.study.regx;

import org.json.JSONException;
import org.json.JSONObject;

public class Ex1_1 {
    public static void main(String[] args) {
        try {
            JSONObject object = new JSONObject();
            JSONObject addressObj = new JSONObject();
            
            
            object.put("name", "김희준");
            addressObj.put("code", 13487);
            addressObj.put("city", "Seongnam");

            object.put("address", addressObj);
    
            System.out.println(object.toString()); 
        } 
        catch (JSONException e) {
            System.err.println(e);
        }


        }
   
}
