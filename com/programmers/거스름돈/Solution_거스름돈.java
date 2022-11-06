package com.programmers.거스름돈;

public class Solution_거스름돈 {
	public static int solution(int n, int[] money) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for(int i = 0; i < money.length; i++) {
        	int m = money[i];
        	for(int j = 1; j <= n; j++) {
        		if(j < m) continue;
        		dp[j] += dp[j - m];
        	}
        }
        return dp[n] % 1000000007;
	}
	public static void main(String[] args) {
		System.out.println(solution(5, new int[] {1, 2, 5}));
	}
}
