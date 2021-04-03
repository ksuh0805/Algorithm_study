package com.swexpert.길찾기1219;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1219_길찾기 {
	static int[] road1, road2;
	static int n;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int tc = 1; tc <= 10; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			road1 = new int[100];
			road2 = new int[100];
			int T = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < k; i++) {
				int idx = Integer.parseInt(st.nextToken());
				if(road1[idx] == 0)	road1[idx] = Integer.parseInt(st.nextToken());
				else road2[idx] = Integer.parseInt(st.nextToken());
			}
			int ans = 0;
			if(move(0)) ans = 1;
			System.out.println("#" + T + " " + ans);
		}
	}
	private static boolean move(int node) {
		if(node == 99) return true;
		int next1 = road1[node];
		int next2 = road2[node];
		if(next1 != 0) {
			if(move(road1[node])) return true;
		}
		if(next2 != 0) {
			if(move(road2[node])) return true;
		}
		return false;
	}
}
