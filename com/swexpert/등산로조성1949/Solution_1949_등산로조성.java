package com.swexpert.등산로조성1949;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1949_등산로조성 {
	static int N, K, max;
	static int[][] map;
	static boolean[][] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			visited = new boolean[N][N];
			max = 0;
			int max = 0;
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] > max) max = map[i][j];
				}
			}
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(map[i][j] == max) {
						trail(i,j, K, 0);
					}
				}
			}
			System.out.println("#" + tc + " " + max);
		}
	}
	static int[][] dir = {{-1,0}, {1,0}, {0,1}, {0,-1}};
	private static void trail(int a, int b, int k, int d) {
		int x = a;
		int y = b;
		int count = 0;
		visited[x][y] = true;
		for(int i = 0; i < 4; i++) {
			int nx = x + dir[i][0];
			int ny = y + dir[i][1];
			count++;
			if(nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny]) continue;
			if(map[nx][ny] >= map[x][y]) {
				if(k == 0) continue;
				int cha = map[nx][ny] - map[x][y];
				if(cha <= k) {
					for(int m = cha; m > 0; m--) {
						map[nx][ny] -= m;
						trail(nx, ny, 0, d + 1);
						visited[nx][ny] = false;
						map[nx][ny] += m;
					}
				}
			}else {
				trail(nx, ny, k, d + 1);
				visited[nx][ny] = false;
				for(int m = 1; m <= k; m++) {
					map[nx][ny] -= m;
					trail(nx, ny, 0, d + 1);
					visited[nx][ny] = false;
					map[nx][ny] += m;
				}
			}
		}
		if(count == 4) {
			max = Math.max(max, d);
		}
		return;
	}
}
