package com.baekjoon.N과M1_15650;

import java.util.Scanner;

public class Solution_15650 {
	static int n, m;
	static int arr[];
	static boolean visited[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		arr = new int[n];
		visited = new boolean[n + 1];
		
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
			if(!visited[i]) {
				visited[i] = true;
				arr[depth] = i;
				permutation(depth + 1);
				visited[i] = false;
			}
		}
	}
}
