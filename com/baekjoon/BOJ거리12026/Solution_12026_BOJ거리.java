package com.baekjoon.BOJ거리12026;

import java.util.Scanner;

public class Solution_12026_BOJ거리 {
	static int N;
	static char[] blocks;
	static int min;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		String s = sc.next();
		blocks = s.toCharArray();
		min = Integer.MAX_VALUE;
		for(int i = 1; i < N - 1; i++) {
			move(0, i, 0);		
		}
		System.out.println(min == Integer.MAX_VALUE ? -1 : min);
	}

	private static void move(int prev, int now, int energy) {
		char pc = blocks[prev];
		char nc = blocks[now];
		if(pc == 'B') {
			if(nc != 'O') return;
		}else if(pc == 'O') {
			if(nc != 'J') return;
		}else {
			if(nc != 'B') return;
		}
		int cha = now - prev;
		if(now == N - 1) {
			energy += cha * cha;
			min = Math.min(min, energy);
			return;
		}
	}
}
