package com.baekjoon.골드바흐파티션17103;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution_17103_골드바흐파티션 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int MAX = 1000000;
		boolean[] check = new boolean[MAX + 1];
		// check[x] = true -> removed
		// check[x] = false -> not removed
		ArrayList<Integer> primes = new ArrayList<>();
		for(int i = 2; i <= MAX; i++) {
			if(check[i] == false) {
				primes.add(i);
				for(int j = i + i; j <= MAX; j += i) {
					check[j] = true;
				}
			}
		}
		// -> 1 - MAX 모든 소수 구함
		int T = sc.nextInt();
		for(int tc = 0; tc < T; tc++) {
			int ans = 0;
			int N = sc.nextInt();
			for(int x : primes) {
				int y = N - x;
				if(x <= y && check[y] == false) {
					ans += 1;
				}
			}
			System.out.println(ans);
		}
	}
}
