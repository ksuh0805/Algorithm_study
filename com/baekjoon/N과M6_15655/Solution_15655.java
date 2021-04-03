package com.baekjoon.N과M6_15655;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_15655 {
	static int n,m,data[];
	static int[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();

		arr = new int[m];
		data = new int[n];
		for(int i = 0; i < n; i++) {
			data[i] = sc.nextInt();
		}
		Arrays.sort(data);
		combination(0, 0);
	}
	public static void combination(int depth, int start) {
		if(m == depth) {
			for(int i = 0; i < m; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			return;
		}
		for(int i = start; i < n; i++) {
			arr[depth] = data[i];
			combination(depth + 1, i + 1);
		}
	}
}
