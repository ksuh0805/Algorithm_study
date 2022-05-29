package com.programmers.예산;

import java.util.Arrays;

public class Solution_예산 {
	public static int solution(int[] d, int budget) {
		int answer = 0;
		int index = 0;
		Arrays.sort(d);
		while(index < d.length) {
			budget -= d[index++];
			if(budget < 0) break;
			answer++;
		}
		return answer;
	}
	public static void main(String[] args) {
		System.out.println(solution(new int[] {1, 3, 2, 5, 4}, 9));
		System.out.println(solution(new int[] {2, 2, 3, 3}, 10));
	}
}
