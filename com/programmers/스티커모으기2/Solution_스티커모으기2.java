package com.programmers.스티커모으기2;

public class Solution_스티커모으기2 {
	public static int solution(int sticker[]) {
        int len = sticker.length;
        if(len == 1) return sticker[0];
        int[] dp = new int[len + 2];
        for(int i = 3; i < len + 2; i++) {
        	dp[i] = Math.max(dp[i - 1], dp[i - 2] + sticker[i - 2]);
        }
        int max1 = dp[len + 1];
        for(int i = 2; i < len + 2; i++) {
        	dp[i] = Math.max(dp[i - 1], dp[i - 2] + sticker[i - 2]);
        }
        int max2 = dp[len];
        
        return Math.max(max1, max2);
    }
	public static void main(String[] args) {
		System.out.println(solution(new int[] {14, 6, 5, 11, 3, 9, 2, 10}));
		System.out.println(solution(new int[] {1, 3, 2, 5, 4}));
	}
}
