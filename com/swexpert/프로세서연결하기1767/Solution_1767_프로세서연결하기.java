package com.swexpert.프로세서연결하기1767;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_1767_프로세서연결하기 {
	static int n;
	static int min = Integer.MAX_VALUE;
	static int[][] cell;
	static ArrayList<int[]> core = new ArrayList<>();
	static boolean[][] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			n = Integer.parseInt(br.readLine());
			cell = new int[n][n];
			visited = new boolean[n][n];
			for(int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < n; j++) {
					cell[i][j] = Integer.parseInt(st.nextToken());
					if(cell[i][j] == 1) core.add(new int[] {i,j});
				}
			}
			
			connect();
			
			System.out.println("#" + tc + " " + min);
		}
	}
	static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	private static void connect() {
		for(int i = 0; i < core.size(); i++) {
			int x = core.get(i)[0];
			int y = core.get(i)[1];
			outer:
			for(int k = 0; k < 4; k++) {
				int nx = x;
				int ny = y;
				while(true) {
					nx += dir[i][0];
					ny += dir[i][1];
					if(visited[nx][ny] || cell[nx][ny] == 1) {
						int mx = x;
						int my = y;
						while(true) {
							if(mx == nx && my == ny) break;
							visited[mx][my] = false;
							mx += dir[i][0];
							my += dir[i][1];
						}
						continue outer;
					}
					else if(nx == 0 || nx == n - 1 || ny == 0 || ny == n - 1) break;
					visited[nx][ny] = true;
				}
				
			}
		}
	}
}
