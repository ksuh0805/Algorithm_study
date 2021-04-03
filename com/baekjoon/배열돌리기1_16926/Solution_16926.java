package com.baekjoon.배열돌리기1_16926;

import java.util.Scanner;

public class Solution_16926 {
	static int n,m,r;
	static int[][] array;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		r = sc.nextInt();
		array = new int[n][m];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				array[i][j] = sc.nextInt();
			}
		}
		for(int i = 0; i < r; i++) {
			roll();			
		}
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				System.out.print(array[i][j] + " ");
			}System.out.println();
		}
	}
	private static void roll() {
		int cnt = Math.min(n, m) / 2;
		int[] dx = {0, 1, 0, -1};
		int[] dy = {1, 0, -1, 0};
		
		for(int i = 0; i < cnt; i++) {
			int x = i;
			int y = i;
			int prev = array[i][i];
			for(int j = 0; j < 4; j++) {
				while(true) {
					int nx = x + dx[j];
					int ny = y + dy[j];
					if(nx < i || ny < i || nx >= n - i || ny >= m - i) break;
					array[x][y] = array[nx][ny];
					x = nx;
					y = ny;
				}
			}
			array[i + 1][i] = prev;
		}
	}
}
