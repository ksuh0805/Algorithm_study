package com.jungol.오목1733;

import java.util.Scanner;

public class JONGOL_1733_오목 {
	static int[][] map = new int[21][21];
	static int[] dx = {0, 1, 1, -1};
	static int[] dy = {1, 0, 1,  1};
	public static void main(String[] args) {
		Scanner sc = new Scanner("0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\n" + 
				"0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\n" + 
				"0 1 2 0 0 2 2 2 1 0 0 0 0 0 0 0 0 0 0\n" + 
				"0 0 1 2 0 0 0 0 1 0 0 0 0 0 0 0 0 0 0\n" + 
				"0 0 0 1 2 0 0 0 0 0 0 0 0 0 0 0 0 0 0\n" + 
				"0 0 0 0 1 2 2 0 0 0 0 0 0 0 0 0 0 0 0\n" + 
				"0 0 1 1 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0\n" + 
				"0 0 0 0 0 0 1 1 0 0 0 0 0 0 0 0 0 0 0\n" + 
				"0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\n" + 
				"0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\n" + 
				"0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\n" + 
				"0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\n" + 
				"0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\n" + 
				"0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\n" + 
				"0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\n" + 
				"0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\n" + 
				"0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\n" + 
				"0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\n" + 
				"0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0");
		for (int i = 1; i < 20; i++) {			
			for (int j = 1; j < 20; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		for (int i = 1; i < 20; i++) {			
			for (int j = 1; j < 20; j++) {
				int currVal = map[i][j];
				if (currVal == 0) continue;
				
				for (int k = 0; k < 4; k++) {
					int count = 1;
					int nx = dx[k] * count;
					int ny = dy[k] * count;
					
					if (currVal == map[i + dx[k] * -1][j + dy[k] * -1]) continue;
					
					while (currVal == map[i + nx][j + ny]) {
						count++;
						nx = dx[k] * count;
						ny = dy[k] * count;
					}
					
					if (count == 5) {
						System.out.println(currVal);
						System.out.println(i + " " + j);
						System.exit(0);
					}
				}
			}
		}
		System.out.println(0);
		sc.close();
	}
}
