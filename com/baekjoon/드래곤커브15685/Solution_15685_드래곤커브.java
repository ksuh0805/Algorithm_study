package com.baekjoon.드래곤커브15685;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_15685_드래곤커브 {
	static int N;
	static int[][] dir = {{0,1}, {-1,0}, {0,-1}, {1,0}};
	static boolean[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new boolean[101][101];
		
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			
			map[y][x] = true;
			ArrayList<Integer> curve = new ArrayList<>();
			curve.add(d);
			x = x + dir[d][1];
			y = y + dir[d][0];
			map[y][x] = true;
			
			for(int j = 1; j <= g; j++) {
				for(int k = curve.size() - 1; k >= 0; k--) {
					d = (curve.get(k) + 1) % 4;
					x = x + dir[d][1];
					y = y + dir[d][0];
					map[y][x] = true;
					curve.add(d);
				}
			}
		}
		int cnt = 0;
		for(int i = 0; i < 100; i++) {
			for(int j = 0; j < 100; j++) {
				if(map[i][j]) {
					if(map[i + 1][j] && map[i][j + 1] && map[i + 1][j + 1]) cnt++;
				}
			}
		}
		System.out.println(cnt);
	}
}
