package com.baekjoon.치킨배달15686;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_15686_치킨배달 {
	static class loc {
		int x;
		int y;
		public loc(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	static int n, m, min;
	static int[][] map;
	static loc[] chi;
	static ArrayList<loc> chicken, home;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		chicken = new ArrayList<>();
		home = new ArrayList<>();
		chi = new loc[m];
		map = new int[n][n];
		min = Integer.MAX_VALUE;
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) home.add(new loc(i, j));
				else if(map[i][j] == 2) chicken.add(new loc(i, j));
			}
		}
		combination(0, 0);
		System.out.println(min);
	}
	private static void combination(int depth, int start) {
		if(depth == m) {
			int sum = 0;
			for(int i = 0; i < home.size(); i++) {
				loc h = home.get(i);
				int len = Integer.MAX_VALUE;
				for(int j = 0; j < m; j++) {
					int distance = Math.abs(h.x - chi[j].x) + Math.abs(h.y - chi[j].y);
					len = Math.min(len, distance);
				}
				sum += len;
			}
			min = Math.min(min, sum);
			return;
		}
		for(int i = start; i < chicken.size(); i++) {
			chi[depth] = chicken.get(i);
			combination(depth + 1, i + 1);
		}
		
	}
}
