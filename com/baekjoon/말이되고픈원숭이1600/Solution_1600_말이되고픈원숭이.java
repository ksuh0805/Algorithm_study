package com.baekjoon.말이되고픈원숭이1600;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_1600_말이되고픈원숭이 {
	static int K, W, H, min;
	static int[][] map;
	static int[][] horsedir = {{-2, -1}, {-1,-2}, {-2,1}, {-1,2}, {1,-2}, {2,-1}, {1, 2},{2,1}};
	static int[][] dir = {{-1,0}, {0,1}, {1,0}, {0,-1}};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		K = sc.nextInt();
		W = sc.nextInt();
		H = sc.nextInt();
		map = new int[H][W];
		min = Integer.MAX_VALUE;
		for(int i = 0; i < H; i++) {
			for(int j = 0; j < W; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		bfs();
		if(min == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(min);
	}
	private static void bfs() {
		Queue<int[]> queue1 = new LinkedList<>(); // horse 횟수 남음
		Queue<int[]> queue2 = new LinkedList<>(); // horse 횟수 다씀
		queue1.offer(new int[] {0, 0, 0, 0});
		boolean[][] visited = new boolean[H][W];
		visited[0][0] = true;
		while(!queue1.isEmpty() || !queue2.isEmpty()) {
			if(!queue1.isEmpty()) {
				int[] loc = queue1.poll();
				for(int i = 0; i < 8; i++) {
					int nx = loc[0] + horsedir[i][0];
					int ny = loc[1] + horsedir[i][1];
					int hcnt = loc[2] + 1;
					int d = loc[3] + 1;
					if(nx == H - 1 && ny == W - 1) min = Math.min(min, d);
					if(nx < 0 || nx >= H || ny < 0 || ny >= W) continue;
					if(map[nx][ny] == 1 || visited[nx][ny]) continue;
					visited[nx][ny] = true;
					if(hcnt < K) queue1.offer(new int[] {nx, ny, hcnt, d});
					else queue2.offer(new int[] {nx, ny, hcnt, d});
				}
				visited[loc[0]][loc[1]] = false;
				for(int i = 0; i < 4; i++) {
					int nx = loc[0] + dir[i][0];
					int ny = loc[1] + dir[i][1];
					int hcnt = loc[2];
					int d = loc[3] + 1;
					if(nx == H - 1 && ny == W - 1) min = Math.min(min, d);
					if(nx < 0 || nx >= H || ny < 0 || ny >= W) continue;
					if(map[nx][ny] == 1 || visited[nx][ny]) continue;
					visited[nx][ny] = true;
					if(hcnt < K) queue1.offer(new int[] {nx, ny, hcnt, d});
					else queue2.offer(new int[] {nx, ny, hcnt, d});
				}
				visited[loc[0]][loc[1]] = false;
			}
			if(!queue2.isEmpty()) {
				int[] loc2 = queue2.poll();
				for(int i = 0; i < 4; i++) {
					int nx = loc2[0] + dir[i][0];
					int ny = loc2[1] + dir[i][1];
					int hcnt = loc2[2];
					int d = loc2[3] + 1;
					if(nx == H - 1 && ny == W - 1) min = Math.min(min, d);
					if(nx < 0 || nx >= H || ny < 0 || ny >= W) continue;
					visited[nx][ny] = true;
					if(map[nx][ny] == 1 || visited[nx][ny]) continue;
					queue2.offer(new int[] {nx, ny, hcnt, d});
				}
				visited[loc2[0]][loc2[1]] = false;
			}
		}
	}
}
