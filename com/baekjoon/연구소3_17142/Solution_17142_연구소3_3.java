package com.baekjoon.연구소3_17142;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_17142_연구소3_3 {
	static int N, M, min, cnt;
	static int[][] map;
	static ArrayList<int[]> viruses;
	static int[] active;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		viruses = new ArrayList<>();
		cnt = 0;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) {
					viruses.add(new int[] {i, j, 0});
				}else if(map[i][j] == 0) cnt++;
			}
		}
        if(cnt == 0) {
            System.out.println(0);
            return;
        }
		active = new int[M];
		min = Integer.MAX_VALUE;
		combination(0, 0);
		if(min == Integer.MAX_VALUE) min = -1;
		System.out.println(min);
	}
	private static void combination(int depth, int start) {
		if(depth == M) {
			simulation();
			return;
		}
		for(int i = start; i < viruses.size(); i++) {
			active[depth] = i;
			combination(depth + 1, i + 1);
		}
	}
	private static void simulation() {
		int[][] temp = new int[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				temp[i][j] = map[i][j];
			}
		}
		int space = cnt;
		Queue<int[]> queue = new LinkedList<>();
		boolean[][] visited = new boolean[N][N];
		for(int i = 0; i < M; i++) {
			int idx = active[i];
			int[] v = viruses.get(idx);
			queue.offer(v);
			visited[v[0]][v[1]] = true;
		}
		while(!queue.isEmpty()) {
			int[] v = queue.poll();
			int x = v[0];
			int y = v[1];
			int t = v[2];
			visited[x][y] = true;
			for(int d = 0; d < 4; d++) {
				int nx = x + dir[d][0];
				int ny = y + dir[d][1];
				if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
				if(visited[nx][ny] || temp[nx][ny] == 1) continue;
				if(temp[nx][ny] == 0) space--;
				if(space == 0) {
					min = Math.min(min, t + 1);
					return;
				}
				visited[nx][ny] = true;
				queue.offer(new int[] {nx, ny, t + 1});
			}
		}
	}
	static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
}
