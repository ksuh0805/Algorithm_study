package com.baekjoon.파티1238;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Solution_파티 {
	static int N, M, X;
	static int[][] map;
	static int[] distance;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		map = new int[N + 1][N + 1];
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
		}
		distance = new int[N + 1];
		for(int i = 1; i <= N; i++) {
			dijkstra(i);
		}
		Arrays.sort(distance);
		System.out.println(distance[N]);
	}
	private static void dijkstra(int start) {
		int[] d = new int[N + 1];
		boolean[] visited = new boolean[N + 1];
		Arrays.fill(d, Integer.MAX_VALUE);
		
		d[start] = 0;
		for(int i = 1; i <= N; i++) {
			int min = Integer.MAX_VALUE;
			int cur = 1;
			for(int j = 1; j <= N; j++) {
				if(!visited[j] && min > d[j]) {
					min = d[j];
					cur = j;
				}
			}
			visited[cur] = true;
			
			for(int j = 1; j <= N; j++) {
				if(!visited[j] && map[cur][j] != 0 && d[j] > min + map[cur][j]) {
					d[j] = min + map[cur][j];
				}
			}
		}
		if(start == X) {
			for(int i = 1; i <= N; i++) {
				distance[i] += d[i];
			}
		}else {
			distance[start] += d[X];
		}
	}
}
