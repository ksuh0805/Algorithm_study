package com.baekjoon.토마토7576;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_7576_토마토 {
	static int N, M;
	static int[][] tomatoes;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		tomatoes = new int[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				tomatoes[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		bfs();
	}
	private static void bfs() {
		Queue<int[]> ripen = new LinkedList<>();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(tomatoes[i][j] == 1) ripen.add(new int[] {i, j});
			}
		}
		int t = 0;
		if(!check()) ripen.clear();
		while(!ripen.isEmpty()) {
			int size = ripen.size();
			while(--size >= 0) {
				int[] loc = ripen.poll();
				int x = loc[0];
				int y = loc[1];
				for(int d = 0; d < 4; d++) {
					int nx = x + dir[d][0];
					int ny = y + dir[d][1];
					if(nx < 0 || nx >= N || ny < 0 || ny >= M 
							|| tomatoes[nx][ny] == -1 || tomatoes[nx][ny] == 1) continue;
					tomatoes[nx][ny] = 1;
					ripen.offer(new int[] {nx, ny});
				}
			}
			t++;
			if(!check()) break;
		}
		System.out.println(!check() ? t : -1);
	}
	static int[][] dir = {{-1,0}, {1,0}, {0,-1}, {0,1}};
	private static boolean check() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(tomatoes[i][j] == 0) return true;
			}
		}
		return false;
	}
}
