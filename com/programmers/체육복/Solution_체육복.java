package com.programmers.체육복;

import java.util.Arrays;

public class Solution_체육복 {
	public static int solution(int n, int[] lost, int[] reserve) {
        int answer = n;
        int[] students = new int[n + 1];
        Arrays.fill(students, 1);
        for(int i = 0; i < reserve.length; i++) {
        	students[reserve[i]]++;
        }
        for(int i = 0; i < lost.length; i++) {
        	students[lost[i]]--;
        }
        for(int i = 1; i <= n; i++) {
        	if(students[i] == 0) {
        		if(i - 1 > 0 && students[i - 1] == 2) {
        			students[i]++;
        			students[i - 1]--;
        		}else if(i + 1 <= n && students[i + 1] == 2) {
        			students[i]++;
        			students[i + 1]--;
        		}
        	}
        }
        for(int i = 1; i <= n; i++) {
        	if(students[i] == 0) answer--;
        }
        return answer;
    }
	public static void main(String[] args) {
		int[] lost = {2, 4};
		int[] reserve = {1, 3, 5};
		System.out.println(solution(5, lost, reserve));
	}
}
