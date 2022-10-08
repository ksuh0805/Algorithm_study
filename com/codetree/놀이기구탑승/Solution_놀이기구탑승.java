package com.codetree.놀이기구탑승;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_놀이기구탑승 {
	static int N;
	static int[][] map;
	static ArrayList<Integer>[] fav;
	static ArrayList<Integer> order;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		fav = new ArrayList[N * N + 1];
		order = new ArrayList<>();
		for(int i = 0; i < N * N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			order.add(n);
			fav[n] = new ArrayList<>();
			fav[n].add(Integer.parseInt(st.nextToken()));
			fav[n].add(Integer.parseInt(st.nextToken()));
			fav[n].add(Integer.parseInt(st.nextToken()));
			fav[n].add(Integer.parseInt(st.nextToken()));
		}
		for(int i = 0; i < N * N; i++) {
			check(i);
		}
		int score = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				int sum = 0;
				ArrayList<Integer> list = fav[map[i][j]];
				for(int d = 0; d < 4; d++) {
					int nx = i + dir[d][0];
					int ny = j + dir[d][1];
					if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
					if(list.contains(map[nx][ny])) sum++;
				}
				if(sum == 1) score += 1;
				else if(sum == 2) score += 10;
				else if(sum == 3) score += 100;
				else if(sum == 4) score += 1000;
			}
		}
		System.out.println(score);
	}
	private static void check(int i) {
		int idx = order.get(i);
		ArrayList<Integer> list = fav[idx];
		int max = 0;
		int empty_max = 0;
		int tx = -1;
		int ty = -1;
		for(int j = 0; j < N; j++) {
			for(int k = 0; k < N; k++) {
				if(map[j][k] != 0) continue;
				int x = j;
				int y = k;
				int sum = 0;
				int empty = 0;
				for(int d = 0; d < 4; d++) {
					int nx = x + dir[d][0];
					int ny = y + dir[d][1];
					if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
					if(map[nx][ny] == 0) empty++;
					else if(list.contains(map[nx][ny])) sum++;
				}
				if(max < sum) {
					max = sum;
					empty_max = empty;
					tx = x;
					ty = y;
				}else if(max == sum) {
					if(empty_max < empty) {
						empty_max = empty;
						tx = x;
						ty = y;
					}else if(empty_max == empty) {
						if(tx > x) {
							tx = x;
							ty = y;
						}else if(tx == x && ty > y) {
							ty = y;
						}
					}
				}
				if(tx == -1 && ty == -1) {
					tx = x;
					ty = y;
				}
			}
		}
		map[tx][ty] = idx;
	}
	static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
}
