package com.baekjoon.소수_2581;

import java.util.Scanner;

public class Solution_2581_소수 {
	static boolean[] isPrime;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		isPrime = new boolean[10001];
		prime();
		int min = Integer.MAX_VALUE;
		int sum = 0;
		boolean find = false;
		for(int i = M; i <= N; i++) {
			if(!isPrime[i]) {
				sum += i;
				if(!find) {
					min = i;
					find = true;
				}
			}
		}
		if(min == Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(sum);
			System.out.println(min);
		}
	}
	private static void prime() {
		for(int i = 2; i < 10001; i++) {
			if(!isPrime[i]) {
				for(int j = i + i; j < 10001; j += i) {
					isPrime[j] = true;
				}				
			}
		}
	}
}
