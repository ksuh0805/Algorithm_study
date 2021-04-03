package com.baekjoon.z1074;

import java.util.Scanner;

public class Solution_1074 {
	static int n, cnt, num;
	static int[][] arr;
	static int[][] dir = {{0,1}, {1,1}, {1,0}};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		cnt = 0;
		num = (int)Math.pow(2, n);
		arr = new int[num][num];
		int r = sc.nextInt();
		int c = sc.nextInt();
		numbering(0, 0);
		System.out.println(arr[r][c]);
	}
	public static void numbering(int x, int y) {
		if(cnt == num) return;
		arr[x][y] = cnt++;
		for(int i = 0; i < 3; i++) {
			int nx = x + dir[i][0]; 
			int ny = y + dir[i][1];
			arr[nx][ny] = cnt++;
		}
		numbering(x, y + (num / 4));
		numbering(x + (num / 4), y);
		numbering(x + (num / 4), y + (num / 4));
	}
}