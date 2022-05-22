package com.programmers.게임맵최단거리;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_게임맵최단거리 {
	static int[][] map, visited;
	static int N, M;
	public static int solution(int[][] maps){
		N = maps.length;
		M = maps[0].length;
		map = maps;
		
		bfs();
		
		return (visited[N - 1][M - 1] == 0 ? -1 : visited[N - 1][M - 1]);
	}
	static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	private static void bfs() {
		Queue<int[]> queue = new LinkedList<>();
		visited = new int[N][M];
		queue.offer(new int[] {0, 0, 1});
		visited[0][0] = 1;
		while(!queue.isEmpty()) {
			int[] pos = queue.poll();
			int x = pos[0];
			int y = pos[1];
			int d = visited[x][y];
			for(int i = 0; i < 4; i++) {
				int nx = x + dir[i][0];
				int ny = y + dir[i][1];
				if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
				else if(map[nx][ny] == 0) continue;
				else if(visited[nx][ny] != 0 && d + 1 >= visited[nx][ny]) continue;
				visited[nx][ny] = d + 1;
				if(nx == N - 1 && ny == M - 1) {
					continue;
				}
				queue.offer(new int[] {nx, ny});
			}
		}
	}
	public static void main(String[] args) {
		System.out.println(solution(new int[][] {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}}));
		System.out.println(solution(new int[][] {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}}));
	}
}
