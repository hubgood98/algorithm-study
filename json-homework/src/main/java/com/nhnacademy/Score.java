package com.nhnacademy;

public class Score {
  private int battleCount;
  private int winCount;

  public Score() {
    this.battleCount = 0;
    this.winCount = 0;
  }

  public int getBattleCount() {
    return battleCount;
  }

  public int getWinCount() {
    return winCount;
  }

  public void setBattleCount(int battleCount) {
    this.battleCount = battleCount;
  }

  public void setWinCount(int winCount) {
    this.winCount = winCount;
  }
}
