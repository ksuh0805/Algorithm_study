package com.baekjoon.N과M5_15654;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_15654 {
	static int n, m;
	static int arr[], data[];
	static boolean visited[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		data = new int[n];
		for(int i = 0; i < n; i++) {
			data[i] = sc.nextInt();
		}
		Arrays.sort(data);
		arr = new int[n];
		visited = new boolean[n];
		
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
		for(int i = 0; i < n; i++) {
			if(!visited[i]) {
				visited[i] = true;
				arr[depth] = data[i];
				permutation(depth + 1);
				visited[i] = false;
			}
		}
	}
}
