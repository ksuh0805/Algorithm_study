package com.programmers.기지국설치;

public class Solution_기지국설치_2 {
	public static int solution(int n, int[] stations, int w) {
		int answer = 0;
		int cur = 1;
		int st = 0;
		
		while(cur <= n) {
			if(st < stations.length && cur >= stations[st] - w) {
				cur = stations[st] + w + 1;
				st++;
			}else {
				cur += 2 * w + 1;
				answer++;
			}
		}

        return answer;
	}

	public static void main(String[] args) {
		System.out.println(solution(11, new int[] { 4, 11 }, 1));
		System.out.println(solution(16, new int[] { 9 }, 2));
	}
}
