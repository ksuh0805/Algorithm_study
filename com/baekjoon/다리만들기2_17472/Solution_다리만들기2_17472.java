package com.baekjoon.다리만들기2_17472;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


public class Solution_다리만들기2_17472 {
	static int N, M;
	static int[] parents;
	static int[][] map, adjMatrix;
	
	static class Edge implements Comparable<Edge>{
		int from;
		int to;
		int distance;
		public Edge(int from, int to, int distance) {
			super();
			this.from = from;
			this.to = to;
			this.distance = distance;
		}
		
		@Override
		public int compareTo(Edge o) {
			return this.distance - o.distance;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int count = 2;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 1) {
					makeIsland(i, j, count);
					count++;
				}
			}
		}
		adjMatrix = new int[count][count];
		parents = new int[count];
		for(int i = 2; i < count; i++) {
			parents[i] = i;
		}
		for(int i = 2; i < count; i++) {
			for(int j = 2; j < count; j++) {
				if(i == j) continue;
				adjMatrix[i][j] = Integer.MAX_VALUE;
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] != 0 && map[i][j] != 1) {
					bridge(i, j);
				}
			}
		}
		System.out.println(kruskal());
	}
	private static int kruskal() {
		int num = adjMatrix[0].length;
		ArrayList<Edge> edges = new ArrayList<>();
		for(int i = 2; i < num; i++) {
			for(int j = 2; j < num; j++) {
				if(i == j || adjMatrix[i][j] == Integer.MAX_VALUE) continue;
				edges.add(new Edge(i, j, adjMatrix[i][j]));
			}
		}
		Collections.sort(edges);
		int sum = 0;
		int cnt = 0;
		for(Edge edge : edges) {
			if(union(edge.from, edge.to)) {
				sum += edge.distance;
				if(++cnt == num - 3) break;
			}
		}
		if(cnt < num - 3) sum = -1;
		return sum;
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
	private static void bridge(int a, int b) {
		int x = a;
		int y = b;
		outer:
		for(int i = 0; i < 4; i++) {
			int d = 0;
			x = a;
			y = b;
			while(true) {
				int nx = x + dir[i][0];
				int ny = y + dir[i][1];
				if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue outer;
				if(map[nx][ny] == 0) {
					d++;
					x = nx;
					y = ny;
					continue;
				}
				if(map[nx][ny] == map[a][b]) continue outer;
				else {
					if(d == 1) continue outer;
					adjMatrix[map[a][b]][map[nx][ny]] = Math.min(d, adjMatrix[map[a][b]][map[nx][ny]]);
					break;
				}
			}
		}
	}
	static int[][] dir = {{-1,0}, {1, 0}, {0,-1}, {0,1}};
	private static void makeIsland(int x, int y, int num) {
		map[x][y] = num;
		for(int i = 0; i < 4; i++) {
			int nx = x + dir[i][0]; 
			int ny = y + dir[i][1];
			if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
			if(map[nx][ny] != 1) continue;
			makeIsland(nx, ny, num);
		}
	}
}
