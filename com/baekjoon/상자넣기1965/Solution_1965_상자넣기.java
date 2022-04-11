package com.baekjoon.상자넣기1965;

import java.util.Scanner;

public class Solution_1965_상자넣기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] box = new int[n];
		for(int i = 0; i < n; i++) {
			box[i] = sc.nextInt();
		}
		int[] d = new int[n];
		int max = 0;
		for(int i = 0; i < n; i++) {
			d[i] = 1; // 초기
			for(int j = 0; j < i; j++) {
				if(box[j] < box[i] && d[i] < d[j] + 1) {
					d[i] = d[j] + 1;
				}
			}
			if(max < d[i]) max = d[i];
		}
		
		System.out.println(max);
	}
}
