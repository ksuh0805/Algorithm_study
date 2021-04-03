package com.baekjoon.nx2타일링11726;

import java.util.Scanner;

public class Solution_11726_2xn타일링 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] d = new int[n + 2];
		d[1] = 1;
		d[2] = 2;
		for(int i = 3; i <= n; i++) {
			d[i] = (d[i - 1] + d[i - 2]) % 10007;
		}
		System.out.println(d[n]);
	}
}
