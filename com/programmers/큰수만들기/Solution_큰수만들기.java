package com.programmers.큰수만들기;

public class Solution_큰수만들기 {
	public static String solution(String number, int k) {
		StringBuilder sb = new StringBuilder();
		int len = number.length();
		int cnt = 0;
		int start = 0;
		int end = k + cnt + 1;
		while(true) {
			if(cnt == len - k) break;
			int idx = start;
			int max = 0;
			for(int i = start; i < end; i++) {
				if(number.charAt(i) - '0' > max) {
					max = number.charAt(i) - '0';
					idx = i;
				}
			}
			sb.append(max);
			cnt++;
			start = idx + 1;
			end = k + cnt + 1;
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(solution("1924", 2));
		System.out.println(solution("1231234", 3));
		System.out.println(solution("4177252841", 4));
	}
}
