package com.baekjoon.한줄로서기_1138;

import java.util.Scanner;

public class Solution_1138_한줄로서기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		int[] res = new int[N];
		res[arr[0]] = 1;
		for (int i = 1; i < N; i++) {
			int n = arr[i];
			int cnt = 0;
			for (int j = 0; j < N; j++) {
				if (res[j] == 0)
					cnt++;
				if (cnt == n + 1) {
					res[j] = i + 1;
					break;
				}
			}
		}
		for (int i = 0; i < N; i++) {
			System.out.print(res[i] + " ");
		}

	}
}
