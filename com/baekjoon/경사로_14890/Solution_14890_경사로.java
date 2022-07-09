package com.baekjoon.경사로_14890;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_14890_경사로 {
	static int N, L;
	static int[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		boolean[] visited;
		int cnt = 0;
		outer:
		for(int i = 0; i < N; i++) {
			visited = new boolean[N];
			int prev = map[i][0];
			for(int j = 1; j < N; j++) {
				if(map[i][j] != prev) {
					if(Math.abs(map[i][j] - prev) > 1) continue outer;
					if(map[i][j] > prev) {
						for(int k = 1; k <= L; k++) {
							if(j - k < 0) continue outer;
							if(map[i][j - k] != prev || visited[j - k]) continue outer;
						}
					}else {
						visited[j] = true;
						for(int k = 1; k < L; k++) {
							if(j + k >= N) continue outer;
							if(map[i][j + k] != map[i][j]) continue outer;
							visited[j + k] = true;
						}
						j += L - 1;
					}
					prev = map[i][j];
				}
			}
			cnt++;
		}
		outer:
		for(int i = 0; i < N; i++) {
			visited = new boolean[N];
			int prev = map[0][i];
			for(int j = 1; j < N; j++) {
				if(map[j][i] != prev) {
					if(Math.abs(map[j][i] - prev) > 1) continue outer;
					if(map[j][i] > prev) {
						for(int k = 1; k <= L; k++) {
							if(j - k < 0) continue outer;
							if(map[j - k][i] != prev || visited[j - k]) continue outer;
						}
					}else {
						visited[j] = true;
						for(int k = 1; k < L; k++) {
							if(j + k >= N) continue outer;
							if(map[j + k][i] != map[j][i]) continue outer;
							visited[j + k] = true;
						}
						j += L - 1;
					}
					prev = map[j][i];
				}
			}
			cnt++;
		}
		System.out.println(cnt);
	}
}
