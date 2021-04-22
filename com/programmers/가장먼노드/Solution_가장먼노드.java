package com.programmers.가장먼노드;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_가장먼노드 {
	static int far;
	static boolean[][] adj;
	static boolean[] visited;
	public static int solution(int n, int[][] edge) {
        adj = new boolean[n + 1][n + 1];
        visited = new boolean[n + 1];
        far = 0;
        for(int i = 0; i < edge.length; i++) {
        	int a = edge[i][0];
        	int b = edge[i][1];
        	adj[a][b] = adj[b][a] = true;
        }
        bfs(n);
        return far;
    }
	
	private static void bfs(int n) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(1);
		visited[1] = true;
		while(!queue.isEmpty()) {
			int size = queue.size();
			if(size != 0) far = size;
			while(--size >= 0) {
				int k = queue.poll();
				for(int i = 2; i <= n; i++) {
					if(adj[k][i] && !visited[i]) {
						queue.offer(i);
						visited[i] = true;
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		int[][] edge = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
		System.out.println(solution(6, edge));
	}
}
