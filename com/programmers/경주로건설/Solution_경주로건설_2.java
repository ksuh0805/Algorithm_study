package com.programmers.경주로건설;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_경주로건설_2 {
	static int N, min;
	static int[][] Board;
	static int[][][] visited;
	public static int solution(int[][] board) {
        min = Integer.MAX_VALUE;
        N = board.length;
        Board = board;
        bfs();
        for(int i = 0; i < 4; i++) {
        	min = Math.min(min, visited[N - 1][N - 1][i]);
        }
        
        return min;
    }
	static int[][] dir = {{-1, 0},{0, 1},{1, 0},{0, -1}};
	private static void bfs() {
		visited = new int[N][N][4];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				for(int k = 0; k < 4; k++) {
					visited[i][j][k] = Integer.MAX_VALUE;					
				}
			}
		}
		Queue<int[]> q = new LinkedList<>();
		if(Board[0][1] == 0) {
			visited[0][1][1] = 100;
			// x, y, d, cost
			q.offer(new int[] {0, 1, 1, 100});
		}
		if(Board[1][0] == 0) {
			visited[1][0][2] = 100;
			q.offer(new int[] {1, 0, 2, 100});
		}
		for(int i = 0; i < 4; i++) {
			visited[0][0][i] = 0;
        }
		
		while(!q.isEmpty()) {
			int[] pos = q.poll();
			int x = pos[0];
			int y = pos[1];
			int d = pos[2];
			int cost = pos[3];
			if(x == N - 1 && y == N - 1) {
				//min = Math.min(min, cost);
				continue;
			}
			for(int i = 0; i < 4; i++) {
				int nx = x + dir[i][0];
				int ny = y + dir[i][1];
				if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
				if(Board[nx][ny] == 1) continue;
				int nCost = cost + 100;
				if((d == 0 || d == 2) && (i == 1 || i == 3)
						|| (d == 1 || d == 3) && (i == 0 || i == 2)) nCost += 500;
				if(nCost <= visited[nx][ny][i]) {
					visited[nx][ny][i] = nCost;
					q.offer(new int[] {nx, ny, i, nCost});
				}
			}
		}
	}
	public static void main(String[] args) {
		System.out.println(solution(new int[][] {{0,0,0},{0,0,0},{0,0,0}}));
		System.out.println(solution(new int[][] {{0,0,0,0,0,0,0,1},{0,0,0,0,0,0,0,0},{0,0,0,0,0,1,0,0},{0,0,0,0,1,0,0,0},{0,0,0,1,0,0,0,1},{0,0,1,0,0,0,1,0},{0,1,0,0,0,1,0,0},{1,0,0,0,0,0,0,0}}));
		System.out.println(solution(new int[][] {{0,0,1,0},{0,0,0,0},{0,1,0,1},{1,0,0,0}}));
		System.out.println(solution(new int[][] {{0,0,0,0,0,0},{0,1,1,1,1,0},{0,0,1,0,0,0},{1,0,0,1,0,1},{0,1,0,0,0,1},{0,0,0,0,0,0}}));
		System.out.println(solution(new int[][] {{0, 0, 0, 0, 0, 0, 0, 0}, {1, 0, 1, 1, 1, 1, 1, 0}, {1, 0, 0, 1, 0, 0, 0, 0}, {1, 1, 0, 0, 0, 1, 1, 1}, {1, 1, 1, 1, 0, 0, 0, 0}, {1, 1, 1, 1, 1, 1, 1, 0}, {1, 1, 1, 1, 1, 1, 1, 0}, {1, 1, 1, 1, 1, 1, 1, 0}}));
	}
}
