// package com.nhnacademy;

// import java.io.BufferedReader;
// import java.io.FileReader;
// import java.io.FileWriter;
// import java.io.IOException;
// import java.io.InputStreamReader;
// import java.util.ArrayList;

// import org.json.JSONArray;
// import org.json.JSONObject;

// public class Main_2 {

// 	static ArrayList<User> userList = new ArrayList<>();

// 	public static void main(String[] args) {

// 		try (BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))) {

// 			String[] inputs = bf.readLine().trim().split("\\s+");
// 			if (inputs[0].equals("--help") || inputs[0].equals("")) {
// 				System.out.println("도움말 온");
// 			}
// 			if (inputs[0].equals("user")) {
// 				switch (inputs[1]) {
// 					case "add":
// 						User user = new User(inputs[2], inputs[3]);
// 						System.out.println(String.format("사용자 %s가 추가되었습니다", user.getNickname()));
// 						break;

// 					case "del":
// 						int index = -1;
// 						for (User userInfo : userList) {
// 							index++;
// 							if (userInfo.getId().equals(inputs[2])) {
// 								break;
// 							}
// 						}
// 						if (index >= 0) {
// 							userList.remove(index);
// 							System.out.println(String.format("사용자 %s가 삭제 되었습니다.", inputs[1]));
// 						} else {
// 							System.out.println("해당 유저를 찾지 못했습니다.");
// 						}
// 						break;

// 					case "list":
// 						System.out.println("ID     Name");
// 						for (User userInfo : userList) {
// 							System.out.println(userInfo.getId() + "    " + userInfo.getNickname());
// 						}
// 						break;
// 					default:
// 						System.out.println("도움말이 필요하시면 --help를 입력하세요");
// 						break;
// 				}
// 			}
// 		} catch (Exception e) {
// 			e.printStackTrace();
// 		}

// 	}
// }