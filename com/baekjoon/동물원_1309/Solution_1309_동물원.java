package com.baekjoon.동물원_1309;

import java.util.Scanner;

public class Solution_1309_동물원 {
	public static void main(String[] args) {		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] d = new int[100001];
		d[0] = 0;
		d[1] = 3;
		d[2] = 7;
		for(int i = 3; i < 100001; i++) {
			d[i] = (d[i - 2] * 3 + (d[i - 1] - d[i - 2]) * 2) % 9901;
		}
		System.out.println(d[N] % 9901);
	}
}
