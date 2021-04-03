package com.baekjoon.도영이가만든맛있는음식2961;

import java.util.Scanner;

public class Solution_2961 {
	static int n;
	static int[] sour, bitter;
	static boolean[] visited;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		visited = new boolean[n];
		sour = new int[n];
		bitter = new int[n];
		for(int i = 0; i < n; i++) {
			sour[i] = sc.nextInt();
			bitter[i] = sc.nextInt();
		}
		subset(0);
		
		System.out.println(min);
		
	}
	public static void subset(int depth) {
		if(depth == n) {
			int ssum = 1;
			int bsum = 0;
			int cnt = 0;
			for(int i = 0; i < n; i++) {
				if(visited[i]) {
					ssum *= sour[i];
					bsum += bitter[i];
					cnt++;
				}
			}
			if(cnt == 0) return;
			min = Math.min(min, Math.abs(ssum - bsum));
			return;
		}
		visited[depth] = true;
		subset(depth + 1);
		visited[depth] = false;
		subset(depth + 1);
	}
}
