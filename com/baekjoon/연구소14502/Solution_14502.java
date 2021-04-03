package com.baekjoon.연구소14502;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_14502 {
	static int N, M, max;
	static int[][] walls, map;
	static ArrayList<int[]> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		list = new ArrayList<>();
		walls = new int[3][2];
		max = 0;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 0) list.add(new int[] {i,j});
			}
		}
		combination(0,0);
		System.out.println(max);
	}
	private static void combination(int depth, int start) {
		if(depth == 3) {
			int[][] result = diffusion();
			int sum = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(result[i][j] == 0) sum++;
				}
			}
			max = Math.max(max, sum);
			return;
		}
		for(int i = start; i < list.size(); i++) {
			walls[depth] = list.get(i);
			combination(depth + 1, i + 1);
		}
	}
	static int[][] dir = {{-1,0}, {1,0}, {0,1}, {0,-1}};
	private static int[][] diffusion() {
		int[][] temp = copy();
		for(int i = 0; i < 3; i++) {
			temp[walls[i][0]][walls[i][1]] = 1;
		}
		Queue<int[]> queue = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(temp[i][j] == 2) {
					queue.offer(new int[] {i,j});
					visited[i][j] = true;
				}
			}
		}
		while(!queue.isEmpty()) {
			int[] loc = queue.poll();
			int x = loc[0];
			int y = loc[1];
			for(int i = 0; i < 4; i++) {
				int nx = x + dir[i][0];
				int ny = y + dir[i][1];
				if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
				if(visited[nx][ny] || temp[nx][ny] != 0) continue;
				temp[nx][ny] = 2;
				queue.offer(new int[] {nx, ny});
				visited[nx][ny] = true;
			}
		}
		return temp;
	}
	private static int[][] copy() {
		int[][] temp = new int[N][M];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				temp[i][j] = map[i][j];
			}
		}
		return temp;
	}
}
