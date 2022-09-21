package com.programmers.N진수게임;

public class Solution_N진수게임 {
	public static String solution(int n, int t, int m, int p) {
        String answer = "";
        String s = "";
        int i = 0;
        int idx = 0;
        while(answer.length() < t) {
        	s += Integer.toString(i, n);
        	i++;
        	if(s.length() >= m * idx + p) {
        		answer += s.charAt(m * idx + p - 1);
        		idx++;
        	}
        }
        return answer.toUpperCase();
    }
	public static void main(String[] args) {
		System.out.println(solution(2, 4, 2, 1));
		System.out.println(solution(16, 16, 2, 1));
		System.out.println(solution(16, 16, 2, 2));
	}
}
