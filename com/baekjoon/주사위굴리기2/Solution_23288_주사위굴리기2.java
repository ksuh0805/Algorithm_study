package com.baekjoon.주사위굴리기2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_23288_주사위굴리기2 {
	static int N, M, K, dx, dy, dd, score;
	static int[][] map;
	static int[] dice = {2, 4, 1, 3, 5, 6}; // 윗면 : dice[2]
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N + 1][M + 1];
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dx = 1;
		dy = 1;
		dd = 0;
		score = 0;
		for(int i = 0; i < K; i++) {
			move(i);
		}
		System.out.println(score);
	}
	static int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}}; // 동 남 서 북
	private static void move(int m) {
		int nx = dx + dir[dd][0];
		int ny = dy + dir[dd][1];
		if(nx <= 0 || nx > N || ny <= 0 || ny > M) {
			dd += 2;
			if(dd > 3) dd -= 4;
			nx = dx + dir[dd][0];
			ny = dy + dir[dd][1];
		}
		dx = nx;
		dy = ny;
		roll();
		
		if(dice[5] > map[dx][dy]) dd++;
		else if(dice[5] < map[dx][dy]) dd--;
		
		if(dd > 3) dd -= 4;
		else if(dd < 0) dd += 4;
		
		bfs();
	} 
	private static void bfs() {
		int n = map[dx][dy];
		Queue<int[]> q = new LinkedList<>();
		boolean[][] visited = new boolean[N + 1][M + 1];
		q.offer(new int[] {dx, dy});
		visited[dx][dy] = true;
		int sum = 1;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int x = cur[0];
			int y = cur[1];
			for(int d = 0; d < 4; d++) {
				int nx = x + dir[d][0];
				int ny = y + dir[d][1];
				if(nx <= 0 || nx > N || ny <= 0 || ny > M) continue;
				if(visited[nx][ny] || map[nx][ny] != n) continue;
				visited[nx][ny] = true;
				q.offer(new int[] {nx, ny});
				sum++;
			}
		}
		score += n * sum;
	}
	private static void roll() {
		int[] temp = new int[6];
		for(int i = 0; i < 6; i++) {
			temp[i] = dice[i];
		}
		
		if(dd == 0) {
			temp[1] = dice[5];
			temp[2] = dice[1];
			temp[3] = dice[2];
			temp[5] = dice[3];
		}else if(dd == 1) {
			temp[0] = dice[5];
			temp[2] = dice[0];
			temp[4] = dice[2];
			temp[5] = dice[4];			
		}else if(dd == 2) {
			temp[1] = dice[2];
			temp[2] = dice[3];
			temp[3] = dice[5];
			temp[5] = dice[1];
		}else {
			temp[0] = dice[2];
			temp[2] = dice[4];
			temp[4] = dice[5];
			temp[5] = dice[0];			
		}
		
		for(int i = 0; i < 6; i++) {
			dice[i] = temp[i];
		}
	}
}
