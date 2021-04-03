package com.swexpert.햄버거다이어트5215;

import java.util.Scanner;

public class Solution_5215 {
	static int n,cal,max;
	static boolean[] isSelected;
	static int[][] foods;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			n = sc.nextInt();
			cal = sc.nextInt();
			isSelected = new boolean[n];
			foods = new int[n][2];
			for(int i = 0; i < n; i++) {
				foods[i][0] = sc.nextInt();
				foods[i][1] = sc.nextInt();
			}
			max = 0;
			hamburger(0);
			
			System.out.println("#" + tc + " " + max);
		}
	}
	public static void hamburger(int cnt) {
		if(cnt == n) {
			int score = 0;
			int calories = 0;
			for(int i = 0; i < n; i++) {
				if(isSelected[i]) {
					score += foods[i][0];
					calories += foods[i][1];
				}
			}
			if(calories <= cal) {
				if(score > max) {
					max = score;
				}
			}
			return;
		}
		isSelected[cnt] = true;
		hamburger(cnt + 1);
		isSelected[cnt] = false;
		hamburger(cnt + 1);
		
	}
}
