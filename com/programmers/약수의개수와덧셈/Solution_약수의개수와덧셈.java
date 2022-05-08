package com.programmers.약수의개수와덧셈;

public class Solution_약수의개수와덧셈 {
	public static int solution(int left, int right) {
        int answer = 0;
        for(int i = left; i < right + 1; i++) {
        	Double sqrt = Math.sqrt(i);
        	if(sqrt == sqrt.intValue()) answer -= i;
        	else answer += i;
        }
        return answer;
    }
	public static void main(String[] args) {
		System.out.println(solution(13, 17));
		System.out.println(solution(24, 27));
	}
}
