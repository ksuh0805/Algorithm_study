package com.baekjoon.로봇청소기14503;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_14503_2 {
	static int n, m, d;
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
		d = Integer.parseInt(st.nextToken());
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		clean(x, y);
		System.out.println(count);
	}
	static int count = 0;
//	static int temp = 0;
	static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	public static void clean(int x, int y) {
		if(!cleaned[x][y] && map[x][y] == 0) {			
			cleaned[x][y] = true;
			count++;
		}else {
			//temp++;
			return;
		}
		int temp = 0;
		while(true) {
			if(d == 0) d = 3;
			else d -= 1;
			temp++;
			int nx = x + dir[d][0];
			int ny = y + dir[d][1];
			if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
			clean(nx, ny);
			if(temp == 4) {
				nx = x - dir[d][0];
				ny = y - dir[d][1];
				clean(nx, ny);
				break;
			}
		}
		return;
	}
}
