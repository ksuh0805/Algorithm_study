package com.programmers.섬연결하기;

import java.util.Arrays;

public class Solution_섬연결하기 {
	static class Edge implements Comparable<Edge>{
		int from, to, weight;
		
		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
	static Edge[] edgeList;
	static int[] parents;
	public static int solution(int n, int[][] costs) {
        edgeList = new Edge[costs.length];
        parents = new int[n];
        for(int i = 0; i < costs.length; i++) {
        	int[] edge = costs[i];
        	edgeList[i] = new Edge(edge[0], edge[1], edge[2]);
        }
        
        Arrays.sort(edgeList);
        
        make();
        int result = 0;
        int count = 0;
        
        for(Edge e : edgeList) {
        	if(union(e.from, e.to)) {
        		result += e.weight;
        		count++;
        		if(count == n - 1) break;
        	}
        }
        
        return result;
    }
	private static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if(aRoot == bRoot) return false;
		parents[bRoot] = aRoot;
		return true;
	}
	private static int findSet(int a) {
		if(parents[a] == a) return a;
		return parents[a] = findSet(parents[a]);
	}
	private static void make() {
		for(int i = 0; i < parents.length; i++) {
			parents[i] = i;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(solution(4, new int[][] {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}}));
	}
}
