package com.programmers.오픈채팅방;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solution_오픈채팅방 {
	public static String[] solution(String[] record) {
        ArrayList<String> list = new ArrayList<>();
        Map<String, String> nickname = new HashMap<>();
        for(int i = 0; i < record.length; i++) {
        	String[] rec = record[i].split("\\s");
        	if(rec[0].equals("Leave")) continue;
        	nickname.put(rec[1], rec[2]);
        }
        for(int i = 0; i < record.length; i++) {
        	String[] rec = record[i].split("\\s");
        	if(rec[0].equals("Change")) continue;
        	String s = "";
        	s = nickname.get(rec[1]) + "님이 ";
        	if(rec[0].equals("Enter")) s += "들어왔습니다.";
        	else s += "나갔습니다.";
        	list.add(s);
        }
        String[] answer = new String[list.size()];
        for(int i = 0; i < list.size(); i++) answer[i] = list.get(i);
        return answer;
    }
	public static void main(String[] args) {
		String[] result = solution(new String[] {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"});
		for(int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}
}
