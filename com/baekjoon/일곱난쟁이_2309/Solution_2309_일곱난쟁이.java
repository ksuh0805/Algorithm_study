package com.baekjoon.일곱난쟁이_2309;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_2309_일곱난쟁이 {
	static int[] arr, res;
	public static void main(String[] args) {
		arr = new int[9];
		res = new int[7];
		Scanner sc = new Scanner(System.in);
		for(int i = 0; i < 9; i++) {
			arr[i] = sc.nextInt();
		}
		combination(0, 0);
		
		
	}
	private static void combination(int depth, int start) {
		if(depth == 7) {
			int sum = 0;
			for(int i = 0; i < 7; i++) {
				sum += res[i];
			}
			if(sum == 100) {
				Arrays.sort(res);
				for(int i = 0; i < 7; i++) {
					System.out.println(res[i]);
				}
				System.exit(0);
			}
			return;
		}
		for(int i = start; i < 9; i++) {
			res[depth] = arr[i];
			combination(depth + 1, i + 1);
		}
	}
}
