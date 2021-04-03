package com.swexpert.장훈이의높은선반1486;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1486_장훈이의높은선반 {
	static int[] heights;
	static boolean[] isSelected;
	static int n, b, min;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			heights = new int[n];
			isSelected = new boolean[n];
			min = Integer.MAX_VALUE;
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < n; i++) {
				heights[i] = Integer.parseInt(st.nextToken());
			}
			subset(0);
			System.out.println("#" + tc + " " + min);
		}
	}
	private static void subset(int depth) {
		if(depth == n) {
			int sum = 0;
			for(int i = 0; i < n; i++) {
				if(isSelected[i]) sum += heights[i];
			}
			if(sum >= b) min = Math.min(min, Math.abs(sum - b));
			return;
		}
		isSelected[depth] = true;
		subset(depth + 1);
		isSelected[depth] = false;
		subset(depth + 1);
	}
}
