package com.baekjoon.미세먼지안녕17144;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_17144_미세먼지안녕 {
	static int R, C, T;
	static ArrayList<Integer> cleaner;
	static int[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		cleaner = new ArrayList<>();
		for(int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == -1) cleaner.add(i);
			}
		}
		for(int i = 0; i < T; i++) {
			diffusion();
			clean();
		}
		int sum = 0;
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				sum += map[i][j];
			}
		}
		System.out.println(sum + 2);
	}
	static int[][] counterclock = {{0,1}, {-1,0}, {0,-1}, {1,0}};
	static int[][] clock = {{0,1}, {1,0}, {0,-1}, {-1,0}};
	private static void clean() {
		int x1 = cleaner.get(0);
		int x2 = cleaner.get(1);
		int x = x1;
		int y = 1;
		int temp1 = map[x][y];
		int temp2 = 0;
		outer1:
		for(int i = 0; i < 4; i++) {
			while(true) {
				int nx = x + counterclock[i][0];
				int ny = y + counterclock[i][1];
				if(nx < 0 || nx >= R || ny < 0 || ny >= C) continue outer1;
				if(nx == x1 && ny == 0) break;
				temp2 = map[nx][ny];
				map[nx][ny] = temp1;
				temp1 = temp2;
				x = nx;
				y = ny;
			}
		}
		map[x1][1] = 0;
		x = x2;
		y = 1;
		temp1 = map[x][y];
		temp2 = 0;
		outer2:
		for(int i = 0; i < 4; i++) {
			while(true) {
				int nx = x + clock[i][0];
				int ny = y + clock[i][1];
				if(nx < 0 || nx >= R || ny < 0 || ny >= C) continue outer2;
				if(nx == x2 && ny == 0) break;
				temp2 = map[nx][ny];
				map[nx][ny] = temp1;
				temp1 = temp2;
				x = nx;
				y = ny;
			}
		}
		map[x2][1] = 0;
	}
	static int[][] dir = {{-1,0}, {0,1}, {1,0}, {0,-1}};
	private static void diffusion() {
		int[][] temp = new int[R][C];
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(map[i][j] > 0) {
					int dust = map[i][j] / 5;
					if(dust == 0) continue;
					int count = 0;
					for(int k = 0; k < 4; k++) {
						int x = i + dir[k][0];
						int y = j + dir[k][1];
						if(x < 0 || x >= R || y < 0 || y >= C) continue;
						if(map[x][y] == -1) continue;
						temp[x][y] +=  dust;
						count++;
					}
					temp[i][j] -= dust * count;
				}
			}
		}
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				map[i][j] += temp[i][j];
			}
		}
	}
}
