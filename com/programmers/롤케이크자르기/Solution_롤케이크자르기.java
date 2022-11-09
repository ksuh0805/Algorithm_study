package com.programmers.롤케이크자르기;

import java.util.HashSet;
import java.util.Set;

public class Solution_롤케이크자르기 {
	public static int solution(int[] topping) {
        int answer = 0;
        int n = topping.length;
        Set<Integer> set = new HashSet<>();
        int[] front = new int[n];
        for(int i = 0; i < n; i++) {
        	set.add(topping[i]);
        	front[i] = set.size();
        }
        int[] rear = new int[n];
        set.clear();
        for(int i = n - 1; i >= 0; i--) {
        	set.add(topping[i]);
        	rear[i] = set.size();
        }
        for(int i = 0; i < n - 1; i++) {
        	if(front[i] == rear[i + 1]) answer++;
        }
        return answer;
    }
	public static void main(String[] args) {
		System.out.println(solution(new int[] {1, 2, 1, 3, 1, 4, 1, 2}));
		System.out.println(solution(new int[] {1, 2, 3, 1, 4}));
	}
}
