package com.swexpert.서로소집합3289;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_3289_서로소집합 {
	static int N, M;
	static int[] parents;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			parents = new int[N];
			for(int i = 0; i < N; i++) {
				parents[i] = i;
			}
			System.out.print("#" + tc + " ");
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int op = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				if(op == 0) {
					union(a - 1, b - 1);
				}else {
					if(findSet(a - 1) == findSet(b - 1)) System.out.print(1);
					else System.out.print(0);
				}
			}
			System.out.println();
		}
	}
	static int findSet(int a) {
		if(parents[a] == a) return a;
//		return findSet(parents[a]); //path compression 전
		return parents[a] = findSet(parents[a]); //path compression 후
	}
	
	static void union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		
		parents[bRoot] = aRoot;
	}
}
