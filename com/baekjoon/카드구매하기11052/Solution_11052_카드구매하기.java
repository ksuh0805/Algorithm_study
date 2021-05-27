package com.baekjoon.카드구매하기11052;

import java.util.Scanner;

public class Solution_11052_카드구매하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] cards = new int[N + 1];
		int[] d = new int[N + 1];
		for(int i = 1; i <= N; i++) {
			cards[i] = sc.nextInt();
		}
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= i; j++) {
				d[i] = Math.max(d[i - j] + cards[j], d[i]);
			}
		}
		System.out.println(d[N]);
	}
}
