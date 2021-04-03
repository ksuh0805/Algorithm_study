package com.baekjoon.퇴사14501;

import java.util.Scanner;

public class Solution_14501 {
	static int n, max;
	static int[] time, price;
	static boolean[] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		time = new int[n];
		price = new int[n];
		visited = new boolean[n];
		for(int i = 0; i < n; i++) {
			time[i] = sc.nextInt();
			price[i] = sc.nextInt();
		}
		max = 0;
		schedule(0);
		System.out.println(max);
	}
	public static void schedule(int depth) {
		if(depth == n) {
			int limit = 0;
			int day = 0;
			int total = 0;
			for(int i = 0; i < n; i++) {
				if(visited[i]) {
					if(i + time[i] > n) break;
					else if(i - day >= limit) {
						day = i;
						limit = time[i];
						total += price[i];
					}else break;
				}
			}
			if(max < total) max = total;
			return;
		}
		visited[depth] = true;
		schedule(depth + 1);
		visited[depth] = false;
		schedule(depth + 1);
	}
}
