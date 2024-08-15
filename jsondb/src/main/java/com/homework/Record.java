package com.homework;

public class Record {
    private int matchCount; //대전횟수
    private int winCount; //승리횟수

    public Record()
    {
        matchCount = 0;
        winCount = 0;
    }

    public Record(int totalMatch, int winCount) {
        this.matchCount = totalMatch;
        this.winCount = winCount;
    }

    int getTotalMatch()
    {
        return matchCount;
    }

    int getwinCount()
    {
        return winCount;
    }

    public void setMatchCount(int matchCount) {
        this.matchCount = matchCount;
    }
    
    public void setWinCount(int winCount) {
        this.winCount = winCount;
    }

}
