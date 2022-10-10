package com.baekjoon.마법사상어와비바라기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_21610_마법사상어와비바라기 {
	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static ArrayList<int[]> clouds, new_clouds;
	static int[][] dir = {{0,0}, {0,-1}, {-1,-1}, {-1,0}, {-1,1}, {0,1}, {1,1}, {1,0}, {1,-1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N + 1][N + 1];
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		clouds = new ArrayList<>();
		clouds.add(new int[] {N, 1});
		clouds.add(new int[] {N, 2});
		clouds.add(new int[] {N - 1, 1});
		clouds.add(new int[] {N - 1, 2});
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			move(d, s);
			water();
		}
		int sum = 0;
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				sum += map[i][j];
			}
		}
		System.out.println(sum);
	}
	private static void water() {
		clouds = new ArrayList<>();
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				if(visited[i][j] || map[i][j] < 2) continue;
				map[i][j] -= 2;
				clouds.add(new int[] {i, j});
			}
		}
	}
	private static void move(int d, int s) {
		visited = new boolean[N + 1][N + 1];
		new_clouds = new ArrayList<>();
		for(int i = 0; i < clouds.size(); i++) {
			int[] c = clouds.get(i);
			int nx = c[0] + dir[d][0] * s;
			int ny = c[1] + dir[d][1] * s;
			if(nx > N) {
				nx %= N;
				if(nx == 0) nx = N;
			}
			else if(nx < 1) {
				while(nx < 1) nx += N;
			}
			if(ny > N) {
				ny %= N;
				if(ny == 0) ny = N;
			}
			else if(ny < 1) {
				while(ny < 1) ny += N;
			}
			map[nx][ny]++;
			visited[nx][ny] = true;
			new_clouds.add(new int[] {nx, ny});
		}
		clouds = new_clouds;
		waterbug();
	}
	private static void waterbug() {
		for(int i = 0; i < clouds.size(); i++) {
			int[] c = clouds.get(i);
			for(int d = 2; d <= 8; d++) {
				if(d % 2 != 0) continue;
				int nx = c[0] + dir[d][0];
				int ny = c[1] + dir[d][1];
				if(nx <= 0 || nx > N || ny <= 0 || ny > N || map[nx][ny] == 0) continue;
				map[c[0]][c[1]]++;
			}
		}
	}
}
