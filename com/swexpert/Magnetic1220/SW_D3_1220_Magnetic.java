package com.swexpert.Magnetic1220;

import java.util.*;
class SW_D3_1220_Magnetic {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int t = 1; t <= 10; t++) {
			sc.nextInt();
			int[][] a = new int[100][100];
			for (int x = 0; x < 100; x++) 
				for (int y = 0; y < 100; y++) 
					a[x][y] = sc.nextInt();
			
			int ans = 0;
			for (int x = 0; x < 100; x++) {
				int s = 0;
				for (int y = 0; y < 100; y++) {
					if (a[y][x] == 0) continue;
					// 현재 이전에 아래로 내려가는 성질이 있는 상태에서 위로 올라가는 상태를 만나면 교착상태이다.
					if (a[y][x] == 2 && s == 1) {
						s = 0;
						ans++;
					}
					s = a[y][x];
				}
			}
			
			System.out.println("#" + t + " " + ans);
		}
	}
}