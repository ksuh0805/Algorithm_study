package com.swexpert.미로2_1227;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_1227_미로2 {
	static int[][] maze;
	static boolean[][] visited;
	static int x,y,xl,yl;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int tc = 1; tc <= 10; tc++) {
			int T = Integer.parseInt(br.readLine());
			maze = new int[100][100];
			visited = new boolean[100][100];
			for(int i = 0; i < 100; i++) {
				String s = br.readLine();
				for(int j = 0; j < 100; j++) {
					maze[i][j] = s.charAt(j) - '0';
					if(maze[i][j] == 2) {
						x = i;
						y = j;
					}else if(maze[i][j] == 3) {
						xl = i;
						yl = j;
					}
				}
			}
			int ans = 0;
			visited[x][y] = true;
			if(dfs(x, y)) ans = 1;
			System.out.println("#" + T + " " + ans);
		}
	}
	static int[][] dir = {{-1,0}, {0,1}, {1,0}, {0,-1}};
	public static boolean dfs(int a, int b) {
		int x = a;
		int y = b;
		if(x == xl && y == yl) return true;
		for(int i = 0; i < 4; i++) {
			int nx = x + dir[i][0];
			int ny = y + dir[i][1];
			if(nx < 0 || nx >= 100 || ny < 0 || ny >= 100 || visited[nx][ny] || maze[nx][ny] == 1) continue;
			visited[nx][ny] = true;
			if(dfs(nx, ny)) return true;
			visited[nx][ny] = false;
		}
		return false;
	}
}
