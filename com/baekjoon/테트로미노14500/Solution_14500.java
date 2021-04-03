package com.baekjoon.테트로미노14500;

import java.util.Scanner;

public class Solution_14500 {
	static int n, m, max;
	static int[][] paper;
	static boolean[][] visited;
	static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		paper = new int[n][m];
		visited = new boolean[n][m];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				paper[i][j] = sc.nextInt();
			}
		}
		for(int i = 0; i < n; i++) {
			for(int  j = 0; j < m; j++) {
				visited[i][j] = true;
				dfs(i,j, 0, paper[i][j]);
				visited[i][j] = false;
				left(i, j);
			}
		}
		System.out.println(max);
	}
	public static void dfs(int x, int y, int depth, int sum) {
		if(depth == 3) {
			max = Math.max(max, sum);
			return;
		}
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
			if(visited[nx][ny] == false) {
				visited[nx][ny] = true;
				dfs(nx, ny, depth + 1, sum + paper[nx][ny]);
				visited[nx][ny] = false;
			}
		}
	}
	public static void left(int x, int y) {
		 // 1. 맵의 꼭지점일때는 ㅗ 모양 불가능
        if ((x == 0 || x == n - 1) && (y == 0 || y == m - 1)) return;

        int sum = paper[x][y];

        // 2. 맵의 테두리일때는 모양이 하나
        if (x == 0)
            sum += paper[x][y - 1] + paper[x][y + 1] + paper[x + 1][y];
        else if (x == n - 1)
            sum += paper[x][y - 1] + paper[x][y + 1] + paper[x - 1][y];
        else if (y == 0)
            sum += paper[x - 1][y] + paper[x + 1][y] + paper[x][y + 1];
        else if (y == m - 1)
            sum += paper[x - 1][y] + paper[x + 1][y] + paper[x][y - 1];
        else {
        // 3. 맵의 테두리가 아닐 때는 4 개의 모양을 비교
            sum = Math.max(sum, paper[x][y] + paper[x + 1][y] + paper[x][y - 1] + paper[x][y + 1]);
            sum = Math.max(sum, paper[x][y] + paper[x - 1][y] + paper[x][y - 1] + paper[x][y + 1]);
            sum = Math.max(sum, paper[x][y] + paper[x][y + 1] + paper[x - 1][y] + paper[x + 1][y]);
            sum = Math.max(sum, paper[x][y] + paper[x][y - 1] + paper[x - 1][y] + paper[x + 1][y]);
        }

        max = Math.max(max, sum);
	}
}
