package com.programmers._3진법뒤집기;

public class Solution_3진법뒤집기 {
	public static int solution(int n) {
        int answer = 0;
        String res = Integer.toString(n, 3);
        String rev = "";
        for(int i = res.length() - 1; i >= 0; i--) {
        	rev += res.charAt(i);
        }
        answer = Integer.parseInt(rev , 3);
        return answer;
    }
	public static void main(String[] args) {
		System.out.println(solution(45));
		System.out.println(solution(125));
	}
}
