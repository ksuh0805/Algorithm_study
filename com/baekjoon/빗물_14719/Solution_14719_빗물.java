package com.baekjoon.빗물_14719;

import java.util.Scanner;

public class Solution_14719_빗물 {
	static int H, W;
	static int[] rain;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		H = sc.nextInt();
		W = sc.nextInt();
		rain = new int[W];
		for(int i = 0; i < W; i++) {
			rain[i] = sc.nextInt();
		}
		int total = 0;
		for(int i = 1; i < W - 1; i++) {
			int left = 0;
			int right = 0;
			for(int j = 0; j < i; j++) {
				left = Math.max(left, rain[j]);
			}
			for(int j = i + 1; j < W; j++) {
				right = Math.max(right, rain[j]);
			}
			if(rain[i] < left && rain[i] < right) {
				total += Math.min(left, right) - rain[i];
			}
		}
		System.out.println(total);
	}
}
