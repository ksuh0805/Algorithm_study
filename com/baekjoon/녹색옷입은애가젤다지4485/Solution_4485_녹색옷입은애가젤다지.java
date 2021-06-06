package com.baekjoon.녹색옷입은애가젤다지4485;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_4485_녹색옷입은애가젤다지 {
	static int N;
	static int[][] map, d;
	static class Node implements Comparable<Node>{
		int x;
		int y;
		int cost;
		
		public Node(int x, int y, int cost) {
			super();
			this.x = x;
			this.y = y;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = 1;
		while(true) {
			N = Integer.parseInt(br.readLine());
			if(N == 0) break;
			map = new int[N][N];
			d = new int[N][N];
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					d[i][j] = Integer.MAX_VALUE;
				}
			}
			
			dijkstra();
			
			System.out.println("Problem " + tc++ + ": " + d[N - 1][N - 1]);
		}
	}
	static int[][] dir = {{-1,0}, {0,1}, {1,0}, {0,-1}};
	private static void dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(0, 0, map[0][0]));
		d[0][0] = map[0][0];
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			if(d[node.x][node.y] < node.cost) continue;
			for(int i = 0; i < 4; i++) {
				int nx = node.x + dir[i][0];
				int ny = node.y + dir[i][1];
				if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
				if(d[nx][ny] > d[node.x][node.y] + map[nx][ny]) {
					d[nx][ny] = d[node.x][node.y] + map[nx][ny];
					pq.offer(new Node(nx, ny, d[nx][ny]));
				}
			}
		}
	}
}
