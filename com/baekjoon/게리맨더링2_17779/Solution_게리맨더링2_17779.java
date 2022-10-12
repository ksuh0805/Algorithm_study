package com.baekjoon.게리맨더링2_17779;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_게리맨더링2_17779 {
	static int N, total, min;
	static int[][] map;
	static boolean[][] section;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		min = Integer.MAX_VALUE;
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				total += map[i][j];
			}
		}
		for(int i = 0; i < N - 2; i++) {
			for(int j = 1; j < N - 1; j++) {
				divide(i, j);
			}
		}
		System.out.println(min);
	}
	private static void divide(int i, int j) {
		int x = i;
		int y = j;
		for(int d1 = 1; d1 < N / 2; d1++) {
			for(int d2 = 1; d2 < N / 2; d2++) {
				if(x + d1 + d2 >= N) continue;
				if(y - d1 < 0 || y + d2 >= N) continue;
				line(x, y, d1 ,d2);
				calc(x, y, d1, d2);
			}
		}
	}
	private static void line(int x, int y, int d1, int d2) {
		section = new boolean[N][N];
		for(int i = 0; i <= d1; i++) {
			section[x + i][y - i] = true;
			section[x + d2 + i][y + d2 - i] = true;
		}
		for(int i = 0; i <= d2; i++) {
			section[x + i][y + i] = true;
			section[x + d1 + i][y - d1 + i] = true;
		}
	}
	private static void calc(int x, int y, int d1, int d2) {
		int[] pop = new int[5];
		for(int i = 0; i < x + d1; i++) {
			for(int j = 0; j <= y; j++) {
				if(section[i][j]) break;
				pop[0] += map[i][j];
			}
		}
		for(int i = 0; i <= x + d2; i++) {
			for(int j = N - 1; j > y; j--) {
				if(section[i][j]) break;
				pop[1] += map[i][j];
			}
		}
		for(int i = x + d1; i < N; i++) {
			for(int j = 0; j < y - d1 + d2; j++) {
				if(section[i][j]) break;
				pop[2] += map[i][j];
			}
		}
		for(int i = x + d2 + 1; i < N; i++) {
			for(int j = N - 1; j >= y - d1 + d2; j--) {
				if(section[i][j]) break;
				pop[3] += map[i][j];
			}
		}
		pop[4] = total - (pop[0] + pop[1] + pop[2] + pop[3]);
		Arrays.sort(pop);
		min = Math.min(min, pop[4] - pop[0]);
	}
}
