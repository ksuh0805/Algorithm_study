package com.programmers.가장긴팰린드롬;

public class Solution_가장긴팰린드롬_2 {
	public static int solution(String s){
        int answer = 0;
        int len = s.length();
        char[] chs = s.toCharArray();
        for(int i = len; i >= 1; i--) {
        	for(int j = 0; j + i <= len; j++) {
        		//String ss = s.substring(j, i + j);
        		if(isPalindrome(i, j, chs)) return i;
        	}
        }
        return answer;
    }
	private static boolean isPalindrome(int len, int start, char[] chs) {
		for(int i = 0; i < len / 2; i++) {
			if(chs[start + i] != chs[start + len - i - 1]) return false;
		}
		return true;
	}
	public static void main(String[] args) {
		System.out.println(solution("abcdcba"));
		System.out.println(solution("abacde"));
	}
}
