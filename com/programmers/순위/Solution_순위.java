package com.programmers.순위;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_순위 {
	static int cnt;
	public static int solution(int n, int[][] results) {
        int[][] game = new int[n + 1][n + 1];
        for(int i = 0; i < results.length; i++) {
        	int win = results[i][0];
        	int lose = results[i][1];
        	game[win][lose] = 1;
        	game[lose][win] = 2;
        }
        cnt = 0;
        for(int i = 1; i <= n; i++) {
        	bfs(i, game, n);
        }
        return cnt;
    }
	private static void bfs(int i, int[][] game, int n) {
		boolean[] visited = new boolean[n + 1];
    	Queue<Integer> q = new LinkedList<>();
    	q.offer(i);
    	visited[i] = true;
    	while(!q.isEmpty()) {
    		int k = q.poll();
    		for(int j = 1; j <= n; j++) {
    			if(!visited[j] && game[k][j] == 1) {
    				q.offer(j);
    				visited[j] = true;
    			}
    		}
    	}
    	q.offer(i);
    	while(!q.isEmpty()) {
    		int k = q.poll();
    		for(int j = 1; j <= n; j++) {
    			if(!visited[j] && game[k][j] == 2) {
    				q.offer(j);
    				visited[j] = true;
    			}
    		}
    	}
    	for(int j = 1; j <= n; j++) {
    		if(!visited[j]) return;
    	}
    	cnt++;
	}
	public static void main(String[] args) {
		System.out.println(solution(5, new int[][] {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}}));
		System.out.println(solution(5, new int[][] {{1, 4}, {4, 2}, {2, 5}, {5, 3}}));
	}
}
