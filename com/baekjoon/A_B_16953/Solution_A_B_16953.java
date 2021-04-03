package com.baekjoon.A_B_16953;

import java.util.Scanner;

public class Solution_A_B_16953 {
	static long A, B;
	static int min;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		A = sc.nextInt();
		B = sc.nextInt();
		min = Integer.MAX_VALUE;
		multiple(A, 0);
		tentimes(A, 0);
		
		System.out.println(min == Integer.MAX_VALUE ? -1 : min + 1);
	}
	private static void tentimes(long a, int cnt) {
		int count = cnt + 1;
		long res = a * 10 + 1;
		if(res == B) {
			min = Math.min(min, count);
			return;
		}else if(res > B) return;
		else {
			multiple(res, count);
			tentimes(res, count);
		}
	}
	private static void multiple(long a, int cnt) {
		int count = cnt + 1;
		long res = a * 2;
		if(res == B) {
			min = Math.min(min, count);
			return;
		}else if(res > B) return;
		else {
			multiple(res, count);
			tentimes(res, count);
		}
	}
}
