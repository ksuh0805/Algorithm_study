package com.baekjoon.점프1890;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1890_점프 {
	static int N, cnt;
	static int[][] map;
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		long[][] d = new long[N][N];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//dfs(0,0);
		d[0][0] = 1;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(i == N - 1 && j == N - 1) continue;
				int num = map[i][j];
				if(i + num < N) d[i + num][j] += d[i][j];
				if(j + num < N) d[i][j + num] += d[i][j];
			}
		}
		System.out.println(d[N - 1][N - 1]);
	}
	private static void dfs(int x, int y) {
		visited[x][y] = true;
		int num = map[x][y];
		if(num == 0) {
			cnt++;
			return;
		}
		if(x + num < N && !visited[x + num][y]) {
			dfs(x + num, y);
			visited[x + num][y] = false;
		}
		if(y + num < N && !visited[x][y + num]) {
			dfs(x, y + num);
			visited[x][y + num] = false;
		}
	}
}
