package com.baekjoon.원판돌리기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Solution_17822_원판돌리기 {
	static int N, M, T;
	static int[][] circle;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		circle = new int[N + 1][M];
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				circle[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			spin(x, d, k);
		}
		int sum = 0;
		for(int i = 1; i <= N; i++) {
			for(int j = 0; j < M; j++) {
				sum += circle[i][j];
			}
		}
		System.out.println(sum);
	}
	private static void spin(int x, int d, int k) {
		for(int i = 1; i <= N; i++) {
			if(i % x != 0) continue;
			int[] c = circle[i];
			for(int a = 0; a < k; a++) {
				if(d == 0) {
					int temp = c[M - 1];
					for(int j = M - 1; j > 0; j--) {
						c[j] = c[j - 1];
					}
					c[0] = temp;
				}else {
					int temp = c[0];
					for(int j = 0; j < M - 1; j++) {
						c[j] = c[j + 1];
					}
					c[M - 1] = temp;
				}
			}
		}
		remove();
	}
	static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
	private static void remove() {
		boolean total = false;
		boolean[][] visited = new boolean[N + 1][M];
		for(int i = 1; i <= N; i++) {
			int[] c = circle[i];
			for(int j = 0; j < M; j++) {
				int n = c[j];
				if(n == 0) continue;
				for(int d = 0; d < 4; d++) {
					int nx = i + dir[d][0];
					int ny = j + dir[d][1];
					if(ny == -1) ny = M - 1;
					else if(ny == M) ny = 0;
					if(nx <= 0 || nx > N) continue;
					if(circle[nx][ny] == n) {
						total = true;
						//c[j] = 0;
						visited[nx][ny] = true;
						visited[i][j] = true;
						//circle[nx][ny] = 0;
					}
				}
			}
		}
		for(int i = 1; i <= N; i++) {
			for(int j = 0; j < M; j++) {
				if(visited[i][j]) circle[i][j] = 0;
			}
		}
		if(!total) {
			avg();
		}
	}
	private static void avg() {
		int sum = 0;
		int n = 0;
		for(int i = 1; i <= N; i++) {
			for(int j = 0; j < M; j++) {
				if(circle[i][j] > 0) {
					sum += circle[i][j];
					n++;
				}
			}
		}
		double res = (double) sum / n;
		for(int i = 1; i <= N; i++) {
			for(int j = 0; j < M; j++) {
				if(circle[i][j] == 0) continue;
				if((double)circle[i][j] > res) {
					circle[i][j]--;
				}else if((double)circle[i][j] < res) {
					circle[i][j]++;
				}
			}
		}
		
	}
}
