package com.baekjoon.수들의합_1789;

import java.util.Scanner;

public class Solution_1789_수들의합 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long S = sc.nextInt();
		long sum = 0;
		long N = 0;
		for(long i = 1; i <= S; i++) {
			sum += i;
			if(S - sum <= i) {
				N = i;
				break;
			}
		}
		System.out.println(N);
	}
}
