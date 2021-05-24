package com.baekjoon.더하기123_9095;

import java.util.Scanner;

public class Solution_9095_123더하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] d = new int[11];
		d[0] = 0;
		d[1] = 1; // 1
		d[2] = 2; // 1 + 1, 2
		d[3] = 4; // 1 + 1 + 1, 1 + 2, 2 + 1, 3
		for(int i = 4; i < 11; i++) {
			d[i] = d[i - 1] + d[i - 2] + d[i - 3];
		}
		for(int tc = 0; tc < T; tc++) {
			int n = sc.nextInt();
			System.out.println(d[n]);
		}
	}
}
