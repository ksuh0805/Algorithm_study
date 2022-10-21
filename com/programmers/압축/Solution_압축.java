package com.programmers.압축;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution_압축 {
	public static int[] solution(String msg) {
        ArrayList<Integer> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < msg.length(); i++) {
        	char c = msg.charAt(i);
        	if(map.get(Character.toString(c)) == null){
        		map.put(Character.toString(c), c - '@');
        	}
        }
        int idx = 0;
        int res = 0;
        int last = 26;
        while(idx < msg.length()) {
        	int offset = 1;
        	//boolean flag = false;
        	while(idx + offset <= msg.length()) {
        		//if(flag) break;
         		String s = msg.substring(idx, idx + offset);
//        		if(s.length() == 1) {
//        			map.put(s, s.charAt(0) - '@');
//        			flag = true;
//        		} else if(map.get(s) == null) {
//        			map.put(s, ++last);
//        			flag = true;
//        		}
        		if(map.get(s) == null) {
        			map.put(s, ++last);
        			break;
        		}
        		offset++;
        		res = map.get(s);
        	}
        	list.add(res);
        	idx += offset - 1;
        }
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
        	answer[i] = list.get(i);
        }
        return answer;
    }
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution("KAKAO")));
		System.out.println(Arrays.toString(solution("TOBEORNOTTOBEORTOBEORNOT")));
		System.out.println(Arrays.toString(solution("ABABABABABABABAB")));
	}
}
