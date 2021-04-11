package com.baekjoon.톱니바퀴14891;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_14891_톱니바퀴 {
	static int[][] gear;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		gear = new int[5][8];
		for(int i = 1; i < 5; i++) {
			String str = br.readLine();
			for(int j = 0; j < 8; j++) {
				gear[i][j] = str.charAt(j) - '0';
			}
		}
		int K = Integer.parseInt(br.readLine());
		for(int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			rotate(n, d);
		}
		int sum = gear[1][0] + gear[2][0] * 2 + gear[3][0] * 4 + gear[4][0] * 8;
		System.out.println(sum);
	}
	// 1 : 시계 / -1 : 반시계
	private static void rotate(int n, int d) {
		ArrayList<int[]> list = new ArrayList<>();
		int nt = n + 1;
		int	dt = d;
		while(nt < 5) {
			if(gear[nt][6] != gear[nt - 1][2]) {
				dt *= -1;
				list.add(new int[] {nt, dt});
			}else break;
			nt++;
		}
		nt = n - 1;
		dt = d;
		while(nt > 0) {
			if(gear[nt][2] != gear[nt + 1][6]) {
				dt *= -1;
				list.add(new int[] {nt, dt});
			}else break;
			nt--;
		}
		if(d == 1) clockwise(n);
		else counterclock(n);
		
		for(int i = 0; i < list.size(); i++) {
			int nth = list.get(i)[0];
			int dir = list.get(i)[1];
			if(dir == 1) clockwise(nth);
			else counterclock(nth);
		}
		
	}
	private static void counterclock(int n) {
		int temp = gear[n][0];
		for(int i = 1; i < 8; i++) {
			gear[n][i - 1] = gear[n][i];
		}
		gear[n][7] = temp;
	}
	private static void clockwise(int n) {
		int last = gear[n][7];
		int temp = gear[n][0];
		for(int i = 1; i < 8; i++) {
			int prev = temp;
			temp = gear[n][i];
			gear[n][i] = prev;
		}
		gear[n][0] = last;
	}
}
