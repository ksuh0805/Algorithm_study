package com.programmers.귤고르기;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution_귤고르기 {
	public static int solution(int k, int[] tangerine) {
		Map<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < tangerine.length; i++) {
			map.put(tangerine[i], map.getOrDefault(tangerine[i], 0) + 1);
		}
		List<Integer> keySet = new ArrayList<>(map.keySet());

		keySet.sort((o1, o2) -> map.get(o2).compareTo(map.get(o1)));
		int answer = 0;
		for(int key : keySet) {
			if(k <= 0) break;
			k -= map.get(key);
			answer++;
		}
        return answer;
    }
	public static void main(String[] args) {
		System.out.println(solution(6, new int[] {1, 3, 2, 5, 4, 5, 2, 3}));
		System.out.println(solution(4, new int[] {1, 3, 2, 5, 4, 5, 2, 3}));
		System.out.println(solution(2, new int[] {1, 1, 1, 1, 2, 2, 2, 3}));
	}
}
