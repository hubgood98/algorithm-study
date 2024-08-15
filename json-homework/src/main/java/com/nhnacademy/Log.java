package com.nhnacademy;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Log {
  private Date date;
  private String beforeData;
  private String changeData;
  SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초", Locale.KOREA);

  public Log(Date date, String beforeData, String changeData) {
    this.date = date;
    this.beforeData = beforeData;
    this.changeData = changeData;
  }

  public Date getDate() {
    return date;
  }

  public String getBeforeData() {
    return beforeData;
  }

  public String getChangeData() {
    return changeData;
  }

  public void setDate() {
    this.date = new Date();
  }

  public void setBeforeData(String beforeData) {
    this.beforeData = beforeData;
  }

  public void setChangeData(String changeData) {
    this.changeData = changeData;
  }
}
