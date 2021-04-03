package com.swexpert.최적경로1247;

import java.util.Scanner;

public class Solution_1247 {
	static int n;
	static int min = Integer.MAX_VALUE;
	static loc company, home;
	static loc[] customer, cms;
	static boolean[] visited;
	
	static class loc{
		int x;
		int y;
		public loc(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			n = sc.nextInt();
			customer = new loc[n];
			visited = new boolean[n];
			cms = new loc[n];
			company = new loc(sc.nextInt(), sc.nextInt());
			home = new loc(sc.nextInt(), sc.nextInt());
			for(int i = 0; i < n; i++) {
				customer[i] = new loc(sc.nextInt(), sc.nextInt());
			}
			permutation(0);
			System.out.println("#" + tc + " " + min);
			min = Integer.MAX_VALUE;
		}
	}
	public static void permutation(int depth) {
		if(depth == n) {
			distance();
			return;
		}
		for(int i = 0; i < n; i++) {
			if(!visited[i]) {
				visited[i] = true;
				cms[depth] = customer[i];
				permutation(depth + 1);
				visited[i] = false;
			}
		}
	}
	private static void distance() {
		int d = 0;
		loc temp = company;
		for(int i = 0; i < n; i++) {
			d += Math.abs(temp.x - cms[i].x) + Math.abs(temp.y - cms[i].y);
			temp = cms[i];
		}
		d += Math.abs(temp.x - home.x) + Math.abs(temp.y - home.y);
		min = Math.min(min, d);
	}
	
}
