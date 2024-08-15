package com.study.regx;

import org.json.JSONArray;
import org.json.JSONObject;

public class Ex6 {
   

    public static void main(String[] args) {
       
        String[] birds = {"갈매기","참새","펭귄"};
        String[] mammalia = {"사자","호랑이","말"};

        JSONArray birdArray = new JSONArray(birds);
        JSONObject birdObject = new JSONObject();
        birdObject.put("조류", birdArray);  
    
        JSONArray mammalArray = new JSONArray(mammalia);
        JSONObject mamalJsonObject = new JSONObject();
        mamalJsonObject.put("포유류", mammalArray);

        JSONArray animalArray = new JSONArray();
        animalArray.put(birds);
        animalArray.put(mammalia);

        // JSONObject animal = new JSONObject("동물",animalArray);
        // animal.put("조류", birdArray);
        // animal.put("포유류", mammalArray);


    }
}


