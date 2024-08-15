package com.homework;

import java.util.ArrayList;

public class CommandProcessor {

    private ArrayList<User> userList;
    private String filePath;

    public CommandProcessor(ArrayList<User> userList, String filePath) {
        this.userList = userList;
        this.filePath = filePath;
    }

    public void processCommand(String command) {
        String[] tokens = command.split(" ");

        if (tokens.length < 2) {
            System.out.println("잘못된 명령어입니다.");
            return;
        }

        String action = tokens[0];
        String subAction = tokens[1];

        if (action.equals("user")) {
            if (subAction.equals("add")) {
                if (tokens.length < 4) {
                    System.out.println("잘못된 명령어입니다. 사용법: user add [id] [nickname]");
                    return;
                }
                String id = tokens[2];
                String nickname = tokens[3];
                //addUser(id, nickname);
            } else {
                System.out.println("지원하지 않는 서브 명령어입니다.");
            }
        } else {
            System.out.println("지원하지 않는 명령어입니다.");
        }
    }
}