package com.swexpert.정사각형방1861;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution_1861 {
	static int n, max, count;
	static int[][] rooms;
	static ArrayList<Integer> list;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			n = sc.nextInt();
			rooms = new int[n][n];
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					rooms[i][j] = sc.nextInt();
				}
			}
			max = 0;
			list = new ArrayList<>();
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					count = 0;
					int now = rooms[i][j];
					if(move(i,j)) {
						list.add(now);
					}
				}
			}
			int number = Collections.min(list);
			System.out.println("#"+ tc + " "+ number + " " + max);
		}
	}
	public static boolean move(int i, int j) {
		count++;
		int x = i;
		int y = j;
		if(y + 1 < n) {
			if(rooms[x][y + 1] == rooms[x][y] + 1)
				move(x, y + 1);
		}
		if(y - 1 >= 0) {
			if(rooms[x][y - 1] == rooms[x][y] + 1)
				move(x, y - 1);
		}
		if(x + 1 < n) {
			if(rooms[x + 1][y] == rooms[x][y] + 1)
				move(x + 1, y);
		}
		if(x - 1 >= 0) {
			if(rooms[x - 1][y] == rooms[x][y] + 1)
				move(x - 1, y);
		}
		if(max < count) {
			max = count;
			list.clear();
			return true;
		}else if(max == count){
			max = count;
			return true;
		}
		return false;
	}
}
