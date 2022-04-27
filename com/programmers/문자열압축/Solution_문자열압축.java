package com.programmers.문자열압축;

public class Solution_문자열압축 {
	public static int solution(String s) {
        int len = s.length();
        int answer = len;
        for(int i = 1; i <= len / 2; i++) {
        	String result = "";
        	int index = i;
        	String pattern = s.substring(0, index);
        	int cnt = 1;
        	while(index + i <= len) {
        		String ss = s.substring(index, index + i);
        		if(ss.equals(pattern)) cnt++;
        		else {
        			if(cnt != 1) {
        				result += Integer.toString(cnt) + pattern;
        				cnt = 1;
        			}else {
        				result += pattern;
        			}
        			pattern = ss;
        		}
        		index += i;
        	}
        	if(cnt != 1) {
				result += Integer.toString(cnt) + pattern;
				cnt = 1;
			}else {
				result += pattern;
			}
        	if(index < len) result += s.substring(index);
        	answer = Math.min(answer, result.length());
        }
        return answer;
    }
	public static void main(String[] args) {
		System.out.println(solution("aabbaccc"));
		System.out.println(solution("ababcdcdababcdcd"));
		System.out.println(solution("abcabcdede"));
		System.out.println(solution("abcabcabcabcdededededede"));
		System.out.println(solution("xababcdcdababcdcd"));
	}
}
