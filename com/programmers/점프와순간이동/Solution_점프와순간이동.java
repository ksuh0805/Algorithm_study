package com.programmers.점프와순간이동;

public class Solution_점프와순간이동 {
	public static int solution(int n) {
		if(n == 1) return 1;
        int ans = 1;
        while(true) {
        	int a = n / 2;
        	int b = n % 2;
        	n = a;
        	if(b == 1) ans++;
        	if(n == 1) break;
        }
        return ans;
    }
	public static void main(String[] args) {
		System.out.println(solution(5));
		System.out.println(solution(6));
		System.out.println(solution(5000));
	}
}
