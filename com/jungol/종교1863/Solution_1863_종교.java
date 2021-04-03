package com.jungol.종교1863;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution_1863_종교 {
	static int N, M;
	static int[] parents, rank;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		parents = new int[N];
		rank = new int[N];
		for(int i = 0; i < N; i++) {
			parents[i] = i;
		}
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			union(a - 1, b - 1);
		}
		Set<Integer> set = new HashSet<>();
		for(int i = 0; i < N; i++) {
			set.add(findSet(i));
		}
		System.out.println(set.size());
	}
	static boolean union(int a, int b) {
		int aRoot = findSet(a);
	    int bRoot = findSet(b);
	    if(aRoot == bRoot) return false;
	    if(rank[aRoot] > rank[bRoot]) {
	        parents[bRoot] = aRoot;
	    }else {
	        parents[aRoot] = bRoot;
	        if(rank[aRoot] == rank[bRoot]) {
	            rank[bRoot]++;
	        }
	    }
		return true;
	}
	static int findSet(int a) {
		if(parents[a] == a) return a;
		return parents[a] = findSet(parents[a]);
	}
}