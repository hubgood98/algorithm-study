package com.nhnacademy;

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

import org.json.JSONArray;
import org.json.JSONObject;

public class Main {

  static ArrayList<User> userList = new ArrayList<>();
  static ArrayList<Item> itemList = new ArrayList<>();
  static Score score = new Score();
  static ArrayList<Log> logList = new ArrayList<>();

  public static void main(String[] args) {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초", Locale.KOREA);
  
    String filePath = "json-homework/src/main/java/com/nhnacademy/db/data.json";

    try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
      StringBuilder jsonContent = new StringBuilder();
      String line;
      while ((line = br.readLine()) != null) {
        jsonContent.append(line);
      }

      // 불러온 데이터 Json으로 변환
      JSONObject jsonObject = new JSONObject(jsonContent.toString());
      // ----------------------

      // Json에 있는 users 데이터 자바 ArrayList에 저장 ----------
      JSONArray usersArray = jsonObject.getJSONArray("users");
      usersArray.forEach(user -> {
        JSONObject userObj = (JSONObject) user;
        String id = userObj.getString("id");
        String nickname = userObj.getString("nickname");
        userList.add(new User(id, nickname));
      });
      // -----------------------

      // Json에 있는 item 데이터 자바 ArrayList에 저장
      JSONArray itemsArray = jsonObject.getJSONArray("items");
      itemsArray.forEach(item -> {
        JSONObject itemObject = (JSONObject) item;
        String id = itemObject.getString("id");
        String model = itemObject.getString("model");
        int health = itemObject.getInt("health");
        int damege = itemObject.getInt("damege");
        int defence = itemObject.getInt("defence");
        int moveSpeed = itemObject.getInt("moveSpeed");
        int attackSpeed = itemObject.getInt("attackSpeed");
        itemList.add(new Item(id, model, health, damege, defence, moveSpeed, attackSpeed));
      });
      // ----------------------

      // score 저장 ------------
      JSONObject scorObject = jsonObject.getJSONObject("score");
      score.setBattleCount(scorObject.getInt("battleCount"));
      score.setWinCount(scorObject.getInt("winCount"));
      // ----------------------

      // log 저장 --------------
      JSONArray logsArray = jsonObject.getJSONArray("log");
      logsArray.forEach(log -> {
        JSONObject logObject = (JSONObject) log;
        String dateString = logObject.getString("date");
        String beforeData = logObject.getString("beforeData");
        String changeData = logObject.getString("changeData");
        
        Date date = null;
        try {
          date = dateFormat.parse(dateString);
        } catch (ParseException e) {
          e.printStackTrace();
        }
        logList.add(new Log(date, beforeData, changeData));
      });
      // -------------------------

      for (User user : userList) {
        System.out.println(user.getId() + " " + user.getNickname());
      }

      // 새로운 로그 데이터 추가
      Date currentDate = new Date();
      Log newLog = new Log(currentDate, "new before data1", "new change data2");
      logList.add(newLog);

      // 변경된 로그 데이터를 JSON 객체로 변환
      JSONObject newLogObject = new JSONObject();
      newLogObject.put("date", dateFormat.format(currentDate));
      newLogObject.put("beforeData", newLog.getBeforeData());
      newLogObject.put("changeData", newLog.getChangeData());

      // 로그 배열에 새로운 로그 데이터 추가
      logsArray.put(newLogObject);

      // JSON 파일에 변경된 데이터 저장
      try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
        writer.write(jsonObject.toString(2));
      } catch (IOException e) {
        e.printStackTrace();
      }
      
      for(Log log : logList) {
        System.out.println(dateFormat.format(log.getDate()));
      }

    } catch (Exception e) {
      e.printStackTrace();
    }

  }

}
