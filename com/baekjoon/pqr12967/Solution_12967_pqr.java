package com.baekjoon.pqr12967;

import java.util.Scanner;

public class Solution_12967_pqr {
	static int N, K, cnt;
	static int[] list;
	static boolean[] isSelected;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		list = new int[N];
		cnt = 0;
		isSelected = new boolean[N];
		for(int i = 0; i < N; i++) {
			list[i] = sc.nextInt();
		}
		subset(0, 0);
		System.out.println(cnt);
	}

	private static void subset(int depth, int count) {
		if(depth == N && count == 3) {
			long result = 1;
			for(int i = 0; i < N; i++) {
				if(isSelected[i]) result *= list[i];
			}
			if(result % K == 0) cnt++;
			return;
		}else if(depth == N) return;
		
		isSelected[depth] = true;
		subset(depth + 1, count + 1);
		isSelected[depth] = false;
		subset(depth + 1, count);
	}
}
