package com.nhnacademy;

public class User {
  private String id;
  private String nickname;

  public User(String id, String nickname) {
    this.id = id;
    this.nickname = nickname;
  }

  public String getId() {
    return id;
  }

  public String getNickname() {
    return nickname;
  }

  public void setId(String id) {
    this.id = id;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }
}
