package com.programmers.성격유형검사하기;

import static org.junit.Assert.*;
import java.util.HashMap;
import java.util.Map;

public class Solution_성격유형검사하기 {
	public static String solution(String[] survey, int[] choices) {
        String answer = "";
        Map<String, Integer> map = new HashMap<>();
        int N = survey.length;
        for(int i = 0; i < N; i++) {
        	String s = survey[i];
        	int c = choices[i];
        	if(c < 4) {
        		String cc = Character.toString(s.charAt(0));
        		map.put(cc, map.getOrDefault(cc, 0) + 4 - c);
        	}else if(c > 4) {
        		String cc = Character.toString(s.charAt(1));
        		map.put(cc, map.getOrDefault(cc, 0) + c - 4);
        	}
        }
        if(map.getOrDefault("R", 0) >= map.getOrDefault("T", 0)) answer += "R";
        else answer += "T";
        if(map.getOrDefault("C", 0) >= map.getOrDefault("F", 0)) answer += "C";
        else answer += "F";
        if(map.getOrDefault("J", 0) >= map.getOrDefault("M", 0)) answer += "J";
        else answer += "M";
        if(map.getOrDefault("A", 0) >= map.getOrDefault("N", 0)) answer += "A";
        else answer += "N";
        return answer;
    }
	public static void main(String[] args) {
		assertTrue(solution(new String[] {"AN", "CF", "MJ", "RT", "NA"}, new int[] {5, 3, 2, 7, 5}).equals("TCMA"));
		assertTrue(solution(new String[] {"TR", "RT", "TR"}, new int[] {7, 1, 3}).equals("RCJA"));
	}
}
