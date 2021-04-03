package com.swexpert.contact1238;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1238_Contact {
	static int N, d, max;
	static boolean[][] contact;
	static boolean[] visited;
	static Queue<Integer> queue;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int tc = 1; tc <= 10; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			contact = new boolean[101][101];
			visited = new boolean[101];
			queue = new LinkedList<>();
			max = 0;
			for(int i = 0; i < N/2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				contact[from][to] = true;
			}
			queue.offer(d);
			visited[d] = true;
			bfs();
			System.out.println("#" + tc + " " + max);
		}
	}
	private static void bfs() {
		while(!queue.isEmpty()) {
			int size = queue.size();
			max = 0;
			while(--size >= 0) {
				int temp = queue.poll();
				max = Math.max(max, temp);
				for(int j = 1; j < 101; j++) {
					if(contact[temp][j] && !visited[j]) {
						queue.offer(j);
						visited[j] = true;
					}
				}
			}
		}
		return;
	}
}
