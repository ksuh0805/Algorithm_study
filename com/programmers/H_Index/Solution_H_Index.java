package com.programmers.H_Index;

import java.util.Arrays;

public class Solution_H_Index {
	public static int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        int n = citations.length;
        int max = citations[n - 1];
        outer:
        for(int i = max; i >= 0; i--) {
        	for(int j = n - 1; j >= 0; j--) {
        		if(citations[j] < i) {
        			int cnt = n - 1 - j;
        			if(cnt >= i) return i;
        			else continue outer;
        		}
        	}
        	if(i == n) return i;
        }
        return answer;
    }
	public static void main(String[] args) {
		//System.out.println(solution(new int[] {4, 0, 6, 1, 5}));
		//System.out.println(solution(new int[] {0, 0, 1, 1, 1}));
		System.out.println(solution(new int[] {10, 11, 12, 13}));
	}
}
