package com.homework;

import org.apache.commons.cli.*;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class Main {
    static ArrayList<User> userList = new ArrayList<>();
    static ArrayList<Item> itemList = new ArrayList<>();
    static ArrayList<Item> recordArrayList = new ArrayList<>();
    static Record record = new Record();
    static ArrayList<Log> logList = new ArrayList<>();

    public static void main(String[] args) {


        SimpleDateFormat dateFM = new SimpleDateFormat("yy년 MM월 dd일 HH시 mm분",Locale.KOREA);
        String filePath = "./user.json"; //파일 경로

        // 파일 불러오기
      try (BufferedReader br = new BufferedReader(new FileReader(filePath))) 
      {
        StringBuilder jsonContent = new StringBuilder();
        String lineText;

        while ((lineText = br.readLine()) != null) {
            jsonContent.append(lineText);
      }

      // 불러온 데이터 Json으로 변환
      JSONObject jsonObject = new JSONObject(jsonContent.toString());
    

      // Json에 있는 users 데이터 자바 ArrayList에 저장
    JSONArray usersArray;
    if(jsonObject.has("users"))
    {
      usersArray = jsonObject.getJSONArray("users");
    }else{
      usersArray = new JSONArray();
      jsonObject.put("users",usersArray);
    }
    for (int i = 0; i < usersArray.length(); i++) 
    {
      JSONObject userObject = usersArray.getJSONObject(i);
      String id = userObject.getString("id");
      String nick = userObject.getString("nickname");
      userList.add(new User(id, nick));
    }


      // Json에 있는 item 데이터 자바 ArrayList에 저장
      JSONArray itemsArray;
      
      if(jsonObject.has("items"))
      {
        itemsArray = jsonObject.getJSONArray("items");
      }else{
        itemsArray = new JSONArray();
        jsonObject.put("items",itemsArray);
      }
      for (int i = 0; i < itemsArray.length(); i++) 
      {
        JSONObject itemObject = itemsArray.getJSONObject(i);
        String id = itemObject.getString("id");
        String model = itemObject.getString("model");
        int hp = itemObject.getInt("hp");
        int atk = itemObject.getInt("atk");
        int def = itemObject.getInt("def");
        int moveSpeed = itemObject.getInt("move");
        int attackSpeed = itemObject.getInt("dps");
        itemList.add(new Item(id, model, hp, atk, def, moveSpeed, attackSpeed));
      }
    

      // 전적 저장 ------------
      JSONObject recordArray;
      String key = "record";
      try{
      if(jsonObject.has(key))
      {
        recordArray = jsonObject.getJSONObject("record");
      }
      else{
        recordArray = new JSONObject();
        jsonObject.put("record",recordArray);

        recordArray.put("Match Count",0); //기본값
        recordArray.put("count of wins",0);
      }
      record.setMatchCount(recordArray.getInt("Match Count"));
      record.setWinCount(recordArray.getInt("count of wins"));
    }catch(JSONException e)
    { e.printStackTrace();
    }
      // log 저장 --------------
      JSONArray logsArray;
      if(jsonObject.has("log"))
      {
        logsArray = jsonObject.getJSONArray("log");
      }else{
        logsArray = new JSONArray();
      }
      logsArray.forEach(log -> {
        JSONObject logObject = (JSONObject) log;
        String dateString = logObject.getString("date");
        String beforeData = logObject.getString("beforeData");
        String changeData = logObject.getString("changeData");
        
        Date date = null;
        try {
          date = dateFM.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        } 
        logList.add(new Log(date, beforeData, changeData));
      });
      
      for (User user : userList) {
        System.out.println(user.getId() + " " + user.getNick());
      }

      Date crnDate = new Date();
      Log newLog = new Log(crnDate, "new before data1", "new change data2");
      logList.add(newLog);

      // 변경된 로그 데이터를 JSON 객체로 변환
      JSONObject newLogObject = new JSONObject();
      newLogObject.put("date", dateFM.format(crnDate));
      newLogObject.put("beforeData", newLog.getBeforeData());
      newLogObject.put("changeData", newLog.getChangeData());

      // 로그 배열에 새로운 로그 데이터 추가
      logsArray.put(newLogObject);

      // JSON 파일에 변경된 데이터 저장
      try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
        writer.write(jsonObject.toString(2)); //들여쓰기 : 2칸
      } catch (IOException e) {
        e.printStackTrace();
      }
      
      for(Log log : logList) {
        System.out.println(dateFM.format(log.getDate()));
      }

    } catch (Exception e) {
      e.printStackTrace();
    }

  }
}
