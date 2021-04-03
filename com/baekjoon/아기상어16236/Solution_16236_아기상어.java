package com.baekjoon.아기상어16236;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_16236_아기상어 {
	static int N, shark, sx, sy, T;
	static int[][] map;
	static ArrayList<int[]> fish;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		shark = 2;
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 9) {
					map[i][j] = -1;
					sx = i;
					sy = j;
				}
			}
		}
		eat();
		System.out.println(T);
	}
	static int[][] dir = {{-1,0}, {0,1}, {1,0}, {0,-1}};
	static int min;
	private static void eat() {
		fish = new ArrayList<>();
		min = Integer.MAX_VALUE;
		while(true) {
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(map[i][j] < shark) {
						check(i,j);
					}
				}
			}
			if(fish.size() == 0) break;
		}
	}
	private static void check(int i, int j) {
		int x = sx;
		int y = sy;
		for(int k = 0; k < 4; k++) {
			int nx = x + dir[i][0];
			int ny = y + dir[i][1];
			if()
		}
	}
}
