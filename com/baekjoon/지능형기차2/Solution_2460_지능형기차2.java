package com.baekjoon.지능형기차2;

import java.util.Scanner;

public class Solution_2460_지능형기차2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cur = 0;
		int max = 0;
		for(int i = 0; i < 10; i++) {
			int out = sc.nextInt();
			int in = sc.nextInt();
			cur += in;
			cur -= out;
			max = Math.max(max, cur);
		}
		System.out.println(max);
	}
}
