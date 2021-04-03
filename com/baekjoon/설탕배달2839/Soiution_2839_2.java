package com.baekjoon.설탕배달2839;

import java.util.Scanner;

public class Soiution_2839_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		if(n == 4 || n == 7) {
			System.out.println(-1);
			return;
		}
		int ans = n / 5;
		if(n % 5 == 1 || n % 5 == 3) {
			ans++;
		}else if(n % 5 == 2 || n % 5 == 4) {
			ans += 2;
		}
		System.out.println(ans);
	}
}