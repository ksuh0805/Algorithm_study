package com.baekjoon.N과M3_15652;

import java.util.Scanner;

public class Solution_15652 {
	static int n, m;
	static int arr[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		arr = new int[n];
		
		permutation(0);
	}
	public static void permutation(int depth) {
		if(depth == m) {
			for(int i = 0; i < m; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			return;
		}
		for(int i = 1; i <= n; i++) {
			arr[depth] = i;
			permutation(depth + 1);
		}
	}
}
