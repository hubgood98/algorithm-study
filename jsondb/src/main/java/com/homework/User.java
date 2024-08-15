package com.homework;

public class User {
    String id;
    String nick;


    public User(String id, String nick)
    {
        this.id = id;
        this.nick = nick;
    }
    public String getId() {
        return id;
    }

    public String getNick() {
        return nick;
    }
    public void setId(String id) {
        this.id = id;
      }
    
      public void setNick(String nick) {
        this.nick = nick;
      }
}

