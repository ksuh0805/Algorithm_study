package com.baekjoon.DFS와BFS1260;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1260_DFS와BFS {
	static int N, M, V;
	static boolean[][] graph;
	static boolean[] visited;
	static Queue<Integer> queue;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		graph = new boolean[1001][1001];
		visited = new boolean[1001];
		queue = new LinkedList<>();
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			graph[from][to] = graph[to][from] = true;
		}
		dfs(V);
		visited = new boolean[1001];
		System.out.println();
		bfs();
	}
	private static void dfs(int current) {
		visited[current] = true;
		System.out.print(current + " ");
		for(int i = 0; i < 1001; i++) {
			if(graph[current][i] && !visited[i]) {
				dfs(i);
			}
		}
	}
	private static void bfs() {
		queue.offer(V);
		visited[V] = true;
		while(!queue.isEmpty()) {
			int current = queue.poll();
			System.out.print(current + " ");
			for(int i = 0; i < 1001; i++) {
				if(graph[current][i] && !visited[i]) {
					queue.offer(i);
					visited[i] = true;
				}
			}
		}
	}
}
