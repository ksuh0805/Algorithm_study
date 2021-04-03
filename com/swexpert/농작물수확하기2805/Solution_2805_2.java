package com.swexpert.농작물수확하기2805;

import java.util.Scanner;

public class Solution_2805_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt();
			
			int[][] farm = new int[n][n];
			for(int i = 0; i < n; i++) {
				String s = sc.next();
				for(int j = 0; j < n; j++) {
					farm[i][j] = s.charAt(j) - '0';
				}
			}
			int k = n / 2;
			int cnt = 0;
			for(int i = 0; i < n; i++) {
				cnt += farm[i][k];
				if(i <= k) {
					for(int j = 1; j <= i; j++) {
						cnt += farm[i][k - j];
						cnt += farm[i][k + j];
					}
				}else {
					for(int j = 2*k - i; j > 0; j--) {
						cnt += farm[i][k - j];
						cnt += farm[i][k + j];
					}
				}
			}
			System.out.println("#"+ tc + " " + cnt);
		}
		
	}
}
