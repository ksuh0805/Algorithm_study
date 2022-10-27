package com.programmers.할인행사;

import java.util.HashMap;
import java.util.Map;

public class Solution_할인행사 {
	public static int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int N = want.length;
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < N; i++) {
        	map.put(want[i], i);
        }
        outer:
        for(int i = 0; i < discount.length - 9; i++) {
        	int[] n = new int[N];
        	for(int j = 0; j < N; j++) {
        		n[j] = number[j];
        	}
        	for(int j = i; j < i + 10; j++) {
        		int idx = map.getOrDefault(discount[j], -1);
        		if(idx == -1) continue;
        		n[idx]--;
        	}
        	for(int j = 0; j < N; j++) {
        		if(n[j] > 0) continue outer;
        	}
        	answer++;
        }
        return answer;
    }
	public static void main(String[] args) {
		System.out.println(solution(new String[] {"banana", "apple", "rice", "pork", "pot"}, new int[] {3, 2, 2, 2, 1}, new String[] {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"}));
		System.out.println(solution(new String[] {"apple"}, new int[] {10}, new String[] {"banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana"}));
	}
}
