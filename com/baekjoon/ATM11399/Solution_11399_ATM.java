package com.baekjoon.ATM11399;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_11399_ATM {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] waiting = new int[N];
		for(int i = 0; i < N; i++) {
			waiting[i] = sc.nextInt();
		}
		Arrays.sort(waiting);
		int sum = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j <= i; j++) {
				sum += waiting[j];
			}
		}
		System.out.println(sum);
	}
	
}
