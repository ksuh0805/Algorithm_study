package com.baekjoon.다리놓기1010;

import java.util.Scanner;

public class Solution_1010_다리놓기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[][] dp = new int[31][31];
		for(int i = 1; i < 31; i++) {
			dp[1][i] = i;
		}
		for(int i = 2; i < 31; i++) {
			for(int j = i; j < 31; j++) {
				dp[i][j] = dp[i][j - 1] + dp[i - 1][j - 1];
			}
		}
		for(int tc = 0; tc < T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			System.out.println(dp[N][M]);
		}
	}
}
