package com.programmers.다트게임;

public class Solution_다트게임 {
	public static int solution(String dartResult) {
        int answer = 0;
        int prev = 0;
        int score = dartResult.charAt(0) - '0';
        for(int i = 1; i < dartResult.length(); i++) {
        	char c = dartResult.charAt(i);
        	if(Character.isDigit(c)) {
        		if(c == '0' && dartResult.charAt(i - 1) == '1') score = 10;
        		else score = c - '0';
        	}else if(c == '#') {
        		answer -= score;
        		prev = -1 * score;
        	}else if(c == '*'){
        		answer += prev;
        		answer += score * 2;
        		prev = score * 2;
        	}else {
        		if(c == 'D') score *= score;
        		else if(c == 'T') score = score * score * score;
        		
        		if(i == dartResult.length() - 1 || (i != dartResult.length() - 1 && Character.isDigit(dartResult.charAt(i + 1)))){
        			answer += score;
        			prev = score;
        		}
        	}
        }
        return answer;
    }
	public static void main(String[] args) {
		System.out.println(solution("1S2D*3T"));
		System.out.println(solution("1D2S#10S"));
		System.out.println(solution("1D2S0T"));
		System.out.println(solution("1S*2T*3S"));
		System.out.println(solution("1D#2S*3S"));
		System.out.println(solution("1T2D3D#"));
		System.out.println(solution("1D2S3T*"));
	}
}
