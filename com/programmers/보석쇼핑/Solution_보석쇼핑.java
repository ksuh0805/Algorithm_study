package com.programmers.보석쇼핑;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution_보석쇼핑 {
	public static int[] solution(String[] gems) {
        int[] answer = new int[2];
        Set<String> set = new HashSet<>();
        for(int i = 0; i < gems.length; i++){
            set.add(gems[i]);
        }
        int N = set.size();
        int left = 0;
        int right = 0;
        int start = 0;
        int end = 0;
        int min = Integer.MAX_VALUE;
        
        Map<String, Integer> map = new HashMap<>();
        while(true) {
        	if(map.size() == N) {
        		map.put(gems[left], map.get(gems[left]) - 1);
        		if(map.get(gems[left]) == 0) map.remove(gems[left]);
        		left++;
        	}else if(right == gems.length) {
        		break;
        	}else {
        		map.put(gems[right], map.getOrDefault(gems[right], 0) + 1);
        		right++;
        	}
        	
        	if(map.size() == N) {
        		if(right - left < min) {
        			min = right - left;
        			start = left + 1;
        			end = right;
        		}
        	}
        }
        
        answer[0] = start;
        answer[1] = end;
        return answer;
    }
	public static void main(String[] args) {
		int[] result = solution(new String[] {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"});
		System.out.println(result[0] + " " + result[1]);
		result = solution(new String[] {"AA", "AB", "AC", "AA", "AC"});
		System.out.println(result[0] + " " + result[1]);
		result = solution(new String[] {"XYZ", "XYZ", "XYZ"});
		System.out.println(result[0] + " " + result[1]);
		result = solution(new String[] {"ZZZ", "YYY", "NNNN", "YYY", "BBB"});
		System.out.println(result[0] + " " + result[1]);
	}
}
