package com.programmers.모음사전;

public class Solution_모음사전 {
	static char[] alpha = {'A','E','I','O','U'};
	static int answer;
	static boolean flag;
	public static int solution(String word) {
		answer = 0;
		flag = false;
        make(word, new StringBuilder());
        return answer;
    }
	private static void make(String word, StringBuilder sb) {
		if(word.equals(sb.toString())) {
			flag = true;
			return;
		}
		if(sb.length() >= 5) return;
		for(int i = 0; i < 5; i++) {
			sb.append(alpha[i]);
			answer++;
			make(word, sb);
			if(flag) return;
			sb.delete(sb.length()-1, sb.length());
		}
	}
	public static void main(String[] args) {
		System.out.println(solution("AAAAE"));
		System.out.println(solution("AAAE"));
		System.out.println(solution("I"));
		System.out.println(solution("EIO"));
	}
}
