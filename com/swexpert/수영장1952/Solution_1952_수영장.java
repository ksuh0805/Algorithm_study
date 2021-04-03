package com.swexpert.수영장1952;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1952_수영장 {
	static int[] prices, counts;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			prices = new int[4];
			counts = new int[12];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < 4; i++) {
				prices[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < 12; i++) {
				counts[i] = Integer.parseInt(st.nextToken());
			}
			int min = calc(11);
			System.out.println("#" + tc + " " + min);
		}
	}
	private static int calc(int month) {
		if(month < 0) return 0;
		int days = calc(month - 1) + prices[0] * counts[month];
		int months = calc(month - 1) + prices[1];
		int threes = calc(month - 3) + prices[2];
		int minval = 0;
		if(days <= months && days <= threes) minval = days;
		else if(months < days && months < threes) minval = months;
		else minval = threes;
		if(minval > prices[3]) minval = prices[3];
		return minval;
	}
}