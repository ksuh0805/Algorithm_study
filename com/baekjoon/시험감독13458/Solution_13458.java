package com.baekjoon.시험감독13458;

import java.util.Scanner;

public class Solution_13458 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long[] students = new long[n];
		for(int i = 0; i < n; i++) {
			students[i] = sc.nextInt();
		}
		long manager = sc.nextInt();
		long submanager = sc.nextInt();
		
		long count  = n;
		for(int i = 0; i < n; i++) {
			long sub = students[i] - manager;
				if(sub > 0) {
					count += sub / submanager;
					if(sub % submanager > 0) count++;
				}
		}
		System.out.println(count);
	}
}
