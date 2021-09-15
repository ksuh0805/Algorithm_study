package com.baekjoon.유기농배추1012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1012_유기농배추 {
	static int M, N, K;
	static int[][] map;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			for(int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map[y][x] = -1;
			}
			int count = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(map[i][j] == -1) {
						move(i, j, count);
						count++;
					}
				}
			}
			System.out.println(count);
		}
	}
	static int[][] dir = {{-1,0}, {1,0}, {0,1}, {0,-1}};
	private static void move(int i, int j, int num) {
		map[i][j] = num;
		for(int d = 0; d < 4; d++) {
			int nx = i + dir[d][0];
			int ny = j + dir[d][1];
			if(nx >= N || nx < 0 || ny >= M || ny < 0) continue;
			if(map[nx][ny] == -1) {
				map[nx][ny] = num;
				move(nx, ny, num);
			}
		}
	}
}
