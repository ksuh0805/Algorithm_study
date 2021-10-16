package com.baekjoon.스타트링크5014;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_5014_스타트링크 {
	static int F, S, G, U, D, count;
	static boolean[] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		F = sc.nextInt();
		S = sc.nextInt();
		G = sc.nextInt();
		U = sc.nextInt();
		D = sc.nextInt();
		count = Integer.MAX_VALUE;
		visited = new boolean[F + 1];
		
		bfs(S);
		System.out.println(count == Integer.MAX_VALUE ? "use the stairs" : count);
	}
	private static void bfs(int S) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {S, 0});
		visited[S] = true;
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			int pos = cur[0];
			int cnt = cur[1];
			if(pos == G) {
				count = cnt;
				return;
			}
			if(pos + U <= F && !visited[pos + U]) {
				queue.offer(new int[] {pos + U, cnt + 1});
				visited[pos + U] = true;
			}
			if(pos - D > 0 && !visited[pos - D]) {
				queue.offer(new int[] {pos - D, cnt + 1});
				visited[pos - D] = true;
			}
		}
	}
}
