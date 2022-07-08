package com.baekjoon.감시15683;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_15683_감시_2 {
	static int N, M, cnt, min;
	static ArrayList<int[]> list;
	static int[] dlist;
	static int[][] map;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		list = new ArrayList<>();
		cnt = 0;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 0 || map[i][j] == 6) continue;
				else if(map[i][j] == 1) list.add(new int[] {i, j, 1});
				else if(map[i][j] == 2) list.add(new int[] {i, j, 2});
				else if(map[i][j] == 3) list.add(new int[] {i, j, 3});
				else if(map[i][j] == 4) list.add(new int[] {i, j, 4});
				else list.add(new int[] {i, j, 5});
				cnt++;
			}
		}
		dlist = new int[cnt];
		visited = new boolean[cnt];
		min = Integer.MAX_VALUE;
		permutation(0);
		
		System.out.println(min);
	}
	static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	private static void permutation(int depth) {
		if(depth == cnt) {
			int rem = simulation();
			min = Math.min(min, rem);
			return;
		}
		for(int i = 0; i < 4; i++) {
			if(!visited[depth]) {
				visited[depth] = true;
				dlist[depth] = i;
				permutation(depth + 1);
				visited[depth] = false;
			}
		}
	}
	private static int simulation() {
		int[][] temp = new int[N][M];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				temp[i][j] = map[i][j];
			}
		}
		for(int i = 0; i < cnt; i++) {
			int[] cctv = list.get(i);
			int x = cctv[0];
			int y = cctv[1];
			int d = dlist[i];
			
			if(cctv[2] == 1) {
				int nx = x;
				int ny = y;
				while(true) {
					nx += dir[d][0];
					ny += dir[d][1];
					if(nx < 0 || nx >= N || ny < 0 || ny >= M) break;
					if(temp[nx][ny] == 6) break;
					if(temp[nx][ny] == 0) temp[nx][ny] = 9;
				}
			}else if(cctv[2] == 2) {
				int nx = x;
				int ny = y;
				while(true) {
					nx += dir[d][0];
					ny += dir[d][1];
					if(nx < 0 || nx >= N || ny < 0 || ny >= M) break;
					if(temp[nx][ny] == 6) break;
					if(temp[nx][ny] == 0) temp[nx][ny] = 9;
				}
				while(true) {
					nx -= dir[d][0];
					ny -= dir[d][1];
					if(nx < 0 || nx >= N || ny < 0 || ny >= M) break;
					if(temp[nx][ny] == 6) break;
					if(temp[nx][ny] == 0) temp[nx][ny] = 9;
				}
			}else if(cctv[2] == 3) {
				int nx = x;
				int ny = y;
				while(true) {
					nx += dir[d][0];
					ny += dir[d][1];
					if(nx < 0 || nx >= N || ny < 0 || ny >= M) break;
					if(temp[nx][ny] == 6) break;
					if(temp[nx][ny] == 0) temp[nx][ny] = 9;
				}
				d += 1;
				if(d == 4) d = 0;
				nx = x;
				ny = y;
				while(true) {
					nx += dir[d][0];
					ny += dir[d][1];
					if(nx < 0 || nx >= N || ny < 0 || ny >= M) break;
					if(temp[nx][ny] == 6) break;
					if(temp[nx][ny] == 0) temp[nx][ny] = 9;
				}
			}else if(cctv[2] == 4) {
				int nx = x;
				int ny = y;
				while(true) {
					nx += dir[d][0];
					ny += dir[d][1];
					if(nx < 0 || nx >= N || ny < 0 || ny >= M) break;
					if(temp[nx][ny] == 6) break;
					if(temp[nx][ny] == 0) temp[nx][ny] = 9;
				}
				d -= 1;
				if(d == -1) d = 3;
				nx = x;
				ny = y;
				while(true) {
					nx += dir[d][0];
					ny += dir[d][1];
					if(nx < 0 || nx >= N || ny < 0 || ny >= M) break;
					if(temp[nx][ny] == 6) break;
					if(temp[nx][ny] == 0) temp[nx][ny] = 9;
				}
				nx = x;
				ny = y;
				while(true) {
					nx -= dir[d][0];
					ny -= dir[d][1];
					if(nx < 0 || nx >= N || ny < 0 || ny >= M) break;
					if(temp[nx][ny] == 6) break;
					if(temp[nx][ny] == 0) temp[nx][ny] = 9;
				}
			}else {
				int nx = x;
				int ny = y;
				while(true) {
					nx += dir[d][0];
					ny += dir[d][1];
					if(nx < 0 || nx >= N || ny < 0 || ny >= M) break;
					if(temp[nx][ny] == 6) break;
					if(temp[nx][ny] == 0) temp[nx][ny] = 9;
				}
				nx = x;
				ny = y;
				while(true) {
					nx -= dir[d][0];
					ny -= dir[d][1];
					if(nx < 0 || nx >= N || ny < 0 || ny >= M) break;
					if(temp[nx][ny] == 6) break;
					if(temp[nx][ny] == 0) temp[nx][ny] = 9;
				}
				d -= 1;
				if(d == -1) d = 3;
				nx = x;
				ny = y;
				while(true) {
					nx += dir[d][0];
					ny += dir[d][1];
					if(nx < 0 || nx >= N || ny < 0 || ny >= M) break;
					if(temp[nx][ny] == 6) break;
					if(temp[nx][ny] == 0) temp[nx][ny] = 9;
				}
				nx = x;
				ny = y;
				while(true) {
					nx -= dir[d][0];
					ny -= dir[d][1];
					if(nx < 0 || nx >= N || ny < 0 || ny >= M) break;
					if(temp[nx][ny] == 6) break;
					if(temp[nx][ny] == 0) temp[nx][ny] = 9;
				}
			}
		}
		int r = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(temp[i][j] == 0) r++;
			}
		}
		return r;
	}
}
