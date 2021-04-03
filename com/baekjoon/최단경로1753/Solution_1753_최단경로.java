package com.baekjoon.최단경로1753;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1753_최단경로 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		//int[][] adjMatrix = new int[V + 1][V + 1];
		ArrayList<int[]>[] adjlist = new ArrayList[V + 1];
		for(int i = 0; i < V + 1; i++) {
			adjlist[i] = new ArrayList<>();
		}
		
		int K = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			//adjMatrix[from][to] = weight;
			adjlist[from].add(new int[] {to, weight});
		}
		int[] distance = new int[V + 1];
		boolean[] visited = new boolean[V + 1];
		
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[K] = 0;
		
		for(int i = 1; i < V + 1; i++) {
			int min = Integer.MAX_VALUE;
			int current = 0; // min 최소비용에 해당하는 정점 번호
			// step1. 처리하지 않은 정점 중에 출발지에서 가장 가까운(최소비용) 정점 선택
			for(int j = 1; j < V + 1; j++) {
				if(!visited[j] && min > distance[j]) {
					min = distance[j];
					current = j;
				}
			}
			visited[current] = true;
			//if(current == V) break;
			
			// step2. 선택된 current를 경유지로 하여 아직 처리하지 않은 다른 정점으로 최소비용 선택
			for(int j = 0; j < adjlist[current].size(); j++) {
//				if(!visited[j] && adjMatrix[current][j] != 0 && distance[j] > min + adjMatrix[current][j]) {
//				distance[j] = min + adjMatrix[current][j];
				int target = adjlist[current].get(j)[0];
				int weight = adjlist[current].get(j)[1];
				if(!visited[target] && distance[target] > min + weight) {
					distance[target] = min + weight;
				}
			}
		}
		
		for(int i = 1; i < V + 1; i++) {
			if(distance[i] == Integer.MAX_VALUE) {
				System.out.println("INF");
			}else {
				System.out.println(distance[i]);					
			}
		}
	}
}
