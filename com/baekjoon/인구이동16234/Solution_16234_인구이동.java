package com.baekjoon.인구이동16234;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_16234_인구이동 {
	static int N, L, R, cnt, day;
	static int[][] map, visited;
	static ArrayList<ArrayList<int[]>> group;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		while(true) {
			if(!check()) break;
			day++;
		}
		System.out.println(day);
	}
	private static boolean check() {
		cnt = 1;
		group = new ArrayList<>();
		visited = new int[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(visited[i][j] == 0)	{
					group.add(new ArrayList<int[]>());
					bfs(i, j);
					cnt++;
				}
			}
		}
		boolean flag = false;
		for(int i = 0; i < group.size(); i++) {
			ArrayList<int[]> list = group.get(i);
			int sum = 0;
			if(list.size() > 1) flag = true;
			for(int j = 0; j < list.size(); j++) {
				int[] xy = list.get(j);
				sum += map[xy[0]][xy[1]];
			}
			sum /= list.size();
			for(int j = 0; j < list.size(); j++) {
				int[] xy = list.get(j);
				map[xy[0]][xy[1]] = sum;
			}
		}
		return flag;
	}
	static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	private static void bfs(int r, int c) {
		ArrayList<int[]> list = group.get(cnt - 1);
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {r, c});
		list.add(new int[] {r, c});
		visited[r][c] = cnt;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int x = cur[0];
			int y = cur[1];
			for(int d = 0; d < 4; d++) {
				int nx = x + dir[d][0];
				int ny = y + dir[d][1];
				if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
				if(visited[nx][ny] != 0) continue;
				if(Math.abs(map[x][y] - map[nx][ny]) < L || Math.abs(map[x][y] - map[nx][ny]) > R) continue;
				visited[nx][ny] = cnt;
				q.offer(new int[] {nx, ny});
				list.add(new int[] {nx, ny});
			}
		}
	}
}
