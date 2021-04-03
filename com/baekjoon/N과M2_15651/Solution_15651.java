package com.baekjoon.N과M2_15651;

import java.util.Scanner;

public class Solution_15651 {
	static int n,m;
	static int[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();

		arr = new int[m];
		
		combination(0, 1);
	}
	public static void combination(int depth, int start) {
		if(m == depth) {
			for(int i = 0; i < m; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			return;
		}
		for(int i = start; i <= n; i++) {
			arr[depth] = i;
			combination(depth + 1, i + 1);
		}
	}
}
