package com.baekjoon.치킨배달15686;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution_15686 {
	static ArrayList<int[]> home = new ArrayList<>();
	static ArrayList<int[]> chicken = new ArrayList<>();
	static int[][] chs;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				int loc = sc.nextInt();
				if(loc == 1) home.add(new int[] {i,j});
				else if(loc == 2) chicken.add(new int[] {i,j});
			}
		}
		for(int i = 1; i <= m; i++) {
			chs = new int[i][2];
			combination(0, 0, i);
		}
		System.out.println(min);
	}
	public static void combination(int depth, int start, int num) {
		if(depth == num) {
			int sum = 0;
			for(int i = 0; i < home.size(); i++) {
				int[] hm = home.get(i);
				int len = 50;
				for(int j = 0; j < num; j++) {
					int[] ch = chs[j];
					len = Math.min(len, Math.abs(hm[0] - ch[0]) + Math.abs(hm[1] - ch[1]));
				}
				sum += len;
			}
			min = Math.min(min, sum);
			return;
		}
		for(int i = start; i < chicken.size(); i++) {
			chs[depth] = chicken.get(i);
			combination(depth + 1, i + 1, num);
		}
	}
}
