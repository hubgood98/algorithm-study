package com.nhnacademy;

public class Item {
  private String id;
  private String model;
  private int health;
  private int damege;
  private int defence;
  private int moveSpeed;
  private int attackSpeed;

  public Item(String id, String model, int health, int damege, int defence, int moveSpeed, int attackSpeed) {
    this.id = id;
    this.model = model;
    this.health = health;
    this.damege = damege;
    this.defence = defence;
    this.moveSpeed = moveSpeed;
    this.attackSpeed = attackSpeed;
  }

  public String getId() {
    return id;
  }

  public String getModel() {
    return model;
  }

  public int getHelth() {
    return health;
  }

  public int getDamage() {
    return damege;
  }

  public int getDefence() {
    return defence;
  }

  public int getMoveSpeed() {
    return moveSpeed;
  }

  public int getAttackSpeed() {
    return attackSpeed;
  }

  public void setId(String id) {
    this.id = id;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public void setHealth(int health) {
    this.health = health;
  }

  public void setDamage(int damage) {
    this.damege = damage;
  }

  public void setDefence(int defence) {
    this.defence = defence;
  }

  public void setMoveSpeed(int moveSpeed) {
    this.moveSpeed = moveSpeed;
  }

  public void setAttackSpeed(int attackSpeed) {
    this.attackSpeed = attackSpeed;
  }


  

  

}
