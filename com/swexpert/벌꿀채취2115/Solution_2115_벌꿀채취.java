package com.swexpert.벌꿀채취2115;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_2115_벌꿀채취 {
	static int N, M, C, max;
	static int[][] map;
	static int[] choice;
	static boolean[] isSelected;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			choice = new int[2];
			max = 0;
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			combination(0, 0);
			System.out.println("#"+ tc + " " + max);
		}
	}
	private static void combination(int depth, int start) {
		if(depth == 2) {
			int[] f = new int[] {choice[0] / N, choice[0] % N};
			int[] s = new int[] {choice[1] / N, choice[1] % N};
			if(f[0] == s[0] && f[1] + M - 1 >= s[1]) return;
			int profit = collect(f) + collect(s);
			max = Math.max(max, profit);
			return;
		}
		for(int i = start; i < N * N; i++) {
			if((i % N) + M - 1 >= N) continue;
			choice[depth] = i;
			combination(depth + 1, i + 1);
		}
	}
	static int max_collect;
	private static int collect(int[] f) {
		int[] temp = Arrays.copyOfRange(map[f[0]], f[1], f[1] + M);
		isSelected = new boolean[M];
		max_collect = 0;
		sub(0, temp);
		return max_collect;
	}
	private static void sub(int depth, int[] temp) {
		if(depth == M) {
			int sum = 0;
			int profit = 0;
			for(int i = 0; i < M; i++) {
				if(isSelected[i]) {
					sum += temp[i];
					profit += temp[i] * temp[i];
				}
			}
			if(sum > C) return;
			max_collect = Math.max(max_collect, profit);
			return;
		}
		isSelected[depth] = true;
		sub(depth + 1, temp);
		isSelected[depth] = false;
		sub(depth + 1, temp);
	}
}
