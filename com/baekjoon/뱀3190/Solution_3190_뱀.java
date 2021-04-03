package com.baekjoon.뱀3190;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution_3190_뱀 {
	static int N, K, L, count, dir;
	static ArrayList<int[]> snake;
	static int[][] map, dirs;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N + 1][N + 1];
		K = sc.nextInt();
		snake = new ArrayList<>();
		for(int i = 0; i < K; i++) {
			int ax = sc.nextInt();
			int ay = sc.nextInt();
			map[ax][ay] = 1;
		}
		L = sc.nextInt();
		dirs = new int[L][2];
		for(int i = 0; i < L; i++) {
			dirs[i][0] = sc.nextInt();
			char c = sc.next().charAt(0);
			if(c == 'L') dirs[i][1] = -1;
			else dirs[i][1] = 1;
		}
		count = 0;
		// 0: 동, 1: 남, 2: 서, 3: 북 
		dir = 0;
		snake.add(new int[] {1, 1});
		while(move()) {
			count += 1;
			for(int[] d : dirs) {
				if(d[0] == count) {
					dir += d[1];
					if(dir == 4) dir = 0;
					else if(dir == -1) dir = 3;
					break;
				}
			}
		}
		System.out.println(count + 1);
	}
	static int[][] dxdy = {{0,1}, {1,0}, {0,-1}, {-1,0}};
	private static boolean move() {
		int x = snake.get(snake.size() - 1)[0];
		int y = snake.get(snake.size() - 1)[1];
		int nx = x + dxdy[dir][0];
		int ny = y + dxdy[dir][1];
		if(nx <= 0 || nx > N || ny <= 0 || ny > N) return false;
		for(int[] s : snake) {
			if(s[0] == nx && s[1] == ny) return false;
		}
		if(map[nx][ny] == 1) {
			map[nx][ny] = 0;
		}else {
			snake.remove(0);
		}
		snake.add(new int[] {nx, ny});
		
		return true;
	}
}
