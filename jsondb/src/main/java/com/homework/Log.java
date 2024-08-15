package com.homework;

import java.util.Date;

public class Log {
  private Date date;
  private String beforeData;
  private String changeData;
  
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
