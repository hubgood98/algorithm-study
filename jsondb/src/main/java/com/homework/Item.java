package com.homework;

import java.util.HashMap;
import java.util.Map;

public class Item {
    private String id;
    private String Model;
    private int hp;
    private int atk;
    private int def;
    private int moveSpeed;
    private int atkSpeed;


    Item(String id, String model, int hp, int atk, int def, int movSpeed, int atkSpeed)
    {
        this.id = id;
        this.Model = model;
        this.hp = hp;
        this.atk = atk;
        this.def = def;
        moveSpeed = movSpeed;
        this.atkSpeed = atkSpeed;
    }

    public String getId() {
        return id;
    }
    public String getModel() {
        return Model;
    }
    public int getHp() {
        return hp;
    }
    public int getAtk() {
        return atk;
    }
    public int getDef() {
        return def;
    }
    public int getMoveSpeed() {
        return moveSpeed;
    }
    public int getAtkSpeed() {
        return atkSpeed;
    }

}