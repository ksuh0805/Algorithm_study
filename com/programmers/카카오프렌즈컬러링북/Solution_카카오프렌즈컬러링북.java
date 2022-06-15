package com.programmers.카카오프렌즈컬러링북;

public class Solution_카카오프렌즈컬러링북 {
	static boolean[][] visited;
	static int[][] pic;
	static int M, N, num, max, area;
	public static int[] solution(int m, int n, int[][] picture) {
		M = m;
		N = n;
		pic = new int[m][n];
		visited = new boolean[m][n];
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				pic[i][j] = picture[i][j];
			}
		}
		num = 0;
		max = 0;
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(!visited[i][j] && pic[i][j] != 0) {
					area = 0;
					dfs(i, j, pic[i][j]);
					num++;
					max = Math.max(max, area);
				}
			}
		}
		int[] ans = new int[2];
		ans[0] = num;
		ans[1] = max;
		return ans;
	}
	static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	private static void dfs(int x, int y, int cur) {
		if(visited[x][y]) return;
		if(pic[x][y] == 0) return;
		if(cur != pic[x][y]) return;
		visited[x][y] = true;
		area++;
		for(int d = 0; d < 4; d++) {
			int nx = x + dir[d][0];
			int ny = y + dir[d][1];
			if(nx < 0 || nx >= M || ny < 0 || ny >= N) continue;
			dfs(nx, ny, pic[x][y]);
		}
	}
	public static void main(String[] args) {
		int[] res = solution(6, 4, new int[][] {{1,1,1,0},{1,2,2,0},{1,0,0,1},{0,0,0,1},{0,0,0,3},{0,0,0,3}});
		System.out.println(res[0] + " " + res[1]);
	}
}
