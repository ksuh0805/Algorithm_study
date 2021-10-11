package com.baekjoon.전쟁_전투1303;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1303_전쟁_전투 {
	static int N, M, w, b;
	static char[][] map;
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[M][N];
		visited = new boolean[M][N];
		for(int i = 0; i < M; i++) {
			String s = br.readLine();
			map[i] = s.toCharArray();
		}
		
		for(int i = 0; i < M; i++) {
			for(int j = 0; j < N; j++) {
				bfs(i, j);
			}
		}
		System.out.println(w + " " + b);
	}
	static int[][] dir = {{-1,0}, {1,0}, {0,-1}, {0,1}};
	public static void bfs(int x, int y) {
		if(visited[x][y]) return;
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {x, y});
        visited[x][y] = true;
		int n = 1;
		while(!queue.isEmpty()) {
			int[] pos = queue.poll();
			int mx = pos[0];
			int my = pos[1];
			for(int d = 0; d < 4; d++) {
				int nx = mx + dir[d][0];
				int ny = my + dir[d][1];
				if(nx < 0 || nx >= M || ny < 0 || ny >= N || visited[nx][ny]) continue;
				if(map[mx][my] != map[nx][ny]) continue;
				queue.offer(new int[] {nx, ny});
				visited[nx][ny] = true;
				n += 1;
			}
		}
		if(map[x][y] == 'B') b += n * n;
		else w += n * n;
	}
}
