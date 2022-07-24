package com.baekjoon.쉽게푸는문제_1292;

import java.util.Scanner;

public class Solution_1292_쉽게푸는문제 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int[] arr = new int[1001];
		int idx = 1;
		for(int i = 1; i < 1001; i++) {
			for(int j = idx; j < idx + i && j < 1001; j++) {
				arr[j] = i;
			}
			idx += i;
		}
		int sum = 0;
		for(int i = A; i <= B; i++) {
			sum += arr[i];
		}
		System.out.println(sum);
	}
}
