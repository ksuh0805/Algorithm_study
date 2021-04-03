package com.baekjoon.빵집3109;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_3109 {
	static int R,C;
	static int cnt;
	static char[][] map;
	static boolean[][] visited;
	static int[] dx = {-1, 0, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st  = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visited = new boolean[R][C];
		for(int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		pipe();
		System.out.println(cnt);
	}
	private static void pipe() {
		for(int i = 0; i < R; i++) {
			visited[i][0] = true;
			dfs(i, 0);
		}
	}
	private static boolean dfs(int r, int c) {
		if(c == C - 1) {
			cnt++;
			return true;
		}
		int nr, nc = c + 1;
		for(int i = 0; i < 3; i++) {
			nr = r + dx[i];
			if(nr < 0 || nr >= R || map[nr][nc] == 'x'|| visited[nr][nc]) continue;
			visited[nr][nc] = true;
			if(dfs(nr, nc)) return true;
		}
		return false;
	}
}
