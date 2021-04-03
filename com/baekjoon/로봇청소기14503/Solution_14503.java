package com.baekjoon.로봇청소기14503;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_14503 {
	static int n, m, d;
	static int[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		clean(x, y, 0);
		
		int count = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(map[i][j] == 2) count++;
			}
		}
		System.out.println(count);
	}
	static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	public static void clean(int x, int y, int rcnt) {
		if(rcnt == 4) {
			if(d == 0) d = 3;
			else d -= 1;
			int nx = x - dir[d][0];
			int ny = y - dir[d][1];
			if(map[nx][ny] != 1) clean(nx, ny, 0);
			else return;
		}else {
			if(map[x][y] == 0) map[x][y] = 2;
			int nx = x + dir[d][0];
			int ny = y + dir[d][1];
			if(map[nx][ny] == 0) {
				if(d == 0) d = 3;
				else d -= 1;
				clean(nx, ny, 0);
			}else {
				if(d == 0) d = 3;
				else d -= 1;
				clean(nx, ny, rcnt + 1);
			}
		}
	}
}
