package com.baekjoon.치즈2636;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2636_치즈 {
	static int N, M, cheeze;
	static int[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} // 입력 완료
		int count = 0;
		do {
			dfs(0, 0);
			count++;
		} while(check());
		System.out.println(count - 1);
		System.out.println(cheeze);
	}
	private static boolean check() {
		int count = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == -1) map[i][j] = 0;
				else if(map[i][j] == 2) {
					map[i][j] = 0;
					count++;
				}
			}
		}
		if(count == 0) return false;
		cheeze = count;
		return true;
	}
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	private static void dfs(int r, int c) {
		int nr, nc;
		map[r][c] = -1;
		for(int d = 0; d < 4; d++) {
			nr = r + dx[d];
			nc = c + dy[d];
			if(nr >= 0 && nc >= 0 && nr < N && nc < M) {
				if(map[nr][nc] == 1) { // 공기랑 닿은 부분
					map[nr][nc] = 2;
				} else if(map[nr][nc] == 0) {
					dfs(nr, nc);
				}
			}
		}
	}
}
