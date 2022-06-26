package com.baekjoon.최소스패닝트리1197;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1197_최소스패닝트리_2 {
	static class Edge implements Comparable<Edge>{
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
//			return this.weight - o.weight;
			return Integer.compare(this.weight, o.weight);
		}
	}
	static int V, E;
	static Edge[] edgeList;
	static int[] parents;
	
	static void make() {
		for(int i = 1; i < V + 1; i++) {
			parents[i] = i;
		}
	}
	static int findSet(int a) {
		if(parents[a] == a) return a;
		return parents[a] = findSet(parents[a]);
	}
	static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if(aRoot == bRoot) return false;
		parents[bRoot] = aRoot;
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		parents = new int[V + 1];
		edgeList = new Edge[E];
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			edgeList[i] = new Edge(a, b, c);
		}
		Arrays.sort(edgeList);
		
		make();
		int result = 0;
		int count = 0;
		
		for(Edge e : edgeList) {
			if(union(e.from, e.to)) {
				result += e.weight;
				count++;
				if(count == V - 1) break;
			}
		}
		System.out.println(result);
	}
}
