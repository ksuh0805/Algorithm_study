package com.programmers.콜라문제;

public class Solution_콜라문제 {
	public static int solution(int a, int b, int n) {
        int answer = 0;
        while(true) {
        	if(n < a) break;
        	int add = n / a * b;
        	int remain = n % a;
        	answer += add;
        	n = add + remain;
        }
        return answer;
    }
	public static void main(String[] args) {
		System.out.println(solution(2, 1, 20));
		System.out.println(solution(3, 1, 20));
	}
}
