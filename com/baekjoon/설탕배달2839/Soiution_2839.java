package com.baekjoon.설탕배달2839;

import java.util.Scanner;

public class Soiution_2839 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int min = 1700;
		for(int i = 0; i <= 1000; i++) {
			for(int j = 0; j <= 1667; j++) {
				if(i * 5 + j * 3 == n) {
					min = Math.min(min, i + j);
				}
			}
		}
		if(min == 1700) min = -1;
		System.out.println(min);
	}
}