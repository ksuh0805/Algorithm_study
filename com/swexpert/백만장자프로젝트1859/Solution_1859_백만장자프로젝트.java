package com.swexpert.백만장자프로젝트1859;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1859_백만장자프로젝트 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			int n = Integer.parseInt(br.readLine());
			int[] prices = new int[n];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < n; i++) {
				prices[i] = Integer.parseInt(st.nextToken());
			}
			long ans = 0;
			int max = 0;
			for(int i = n - 1; i >= 0; i--) {
				if(max < prices[i]) max = prices[i];
				else ans += max - prices[i];
			}
			System.out.println("#" + tc + " " + ans);
		}
	}
}
