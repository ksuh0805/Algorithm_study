package com.baekjoon.바이러스2606;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_바이러스_2606 {
	static boolean[][] map;
	static int N, cnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		cnt = -1;
		map = new boolean[N  + 1][N  + 1];
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a][b] = map[b][a] = true;
		}
		bfs();
		System.out.println(cnt);
	}

	private static void bfs() {
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[N + 1];
		visited[1] = true;
		queue.offer(1);
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			cnt++;
			for(int i = 1; i < N + 1; i++) {
				if(visited[i] || !map[cur][i]) continue;
				queue.offer(i);
				visited[i] = true;
			}
		}
	}
}
