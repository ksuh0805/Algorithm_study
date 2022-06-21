package com.baekjoon.로봇청소기14503;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_14503_로봇청소기 {
	static int n, m, cnt;
	static int[][] map;
	static boolean[][] cleaned;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		cleaned = new boolean[n][m];
		st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		clean(x, y, d, 0);
		System.out.println(cnt);
	}
	static int[][] dir = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
	private static void clean(int x, int y, int d, int k) {
		if(k == 4) {
			int dd = d - 1;
			if(dd < 0) dd = 3;
			int dx = x + dir[dd][0];
			int dy = y + dir[dd][1];
			if(dx < 0 || dx >= n || dy < 0 || dy >= m) return;
			if(map[dx][dy] == 1) return;
			clean(dx, dy, d, 0);
			return;
		}
		if(!cleaned[x][y]) {
			cleaned[x][y] = true;
			cnt++;			
		}
		int nx = x + dir[d][0];
		int ny = y + dir[d][1];
		if(nx < 0 || nx >= n || ny < 0 || ny >= m){
			d--;
			if(d < 0) d = 3;
			clean(x, y, d, k + 1);
		}else if(map[nx][ny] == 1){
			d--;
			if(d < 0) d = 3;
			clean(x, y, d, k + 1);
		}else if(!cleaned[nx][ny]) {
			d--;
			if(d < 0) d = 3;
			clean(nx, ny, d, 0);
		}else {
			d--;
			if(d < 0) d = 3;
			clean(x, y, d, k + 1);
		}
	}
}
