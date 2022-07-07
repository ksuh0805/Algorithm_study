package com.baekjoon.아기상어16236;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_16236_아기상어_2 {
	static int N, shark, sx, sy, ecnt, T;
	static int[][] map;
	static boolean remain;
	static ArrayList<int[]> fish;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		shark = 2;
		fish = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				int a = Integer.parseInt(st.nextToken());
				if(a == 9) {
					sx = i;
					sy = j;
					continue;
				}else if(a != 0){
					fish.add(new int[] {i , j});
				}
				map[i][j] = a;
			}
		}
		remain = true;
		while(remain) {
			eat();
		}
		System.out.println(T);
	}
	static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	private static void eat() {
		int tx = 0;
		int ty = 0;
		int td = Integer.MAX_VALUE;
		int idx = 0;
		outer:
		for(int i = 0; i < fish.size(); i++) {
			int[] f = fish.get(i);
			int fx = f[0];
			int fy = f[1];
			if(map[fx][fy] >= shark) continue;
			Queue<int[]> q = new LinkedList<>();
			boolean[][] visited = new boolean[N][N];
			q.offer(new int[] {sx, sy, 0});
			visited[sx][sy] = true;
			while(!q.isEmpty()) {
				int[] cur = q.poll();
				int x = cur[0];
				int y = cur[1];
				int c = cur[2];
				for(int d = 0; d < 4; d++) {
					int nx = x + dir[d][0];
					int ny = y + dir[d][1];
					if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
					if(map[nx][ny] > shark) continue;
					if(visited[nx][ny]) continue;
					if(nx == fx && ny == fy) {
						if(c + 1 < td) {
							tx = nx;
							ty = ny;
							td = c + 1;
							idx = i;
						}else if(c + 1 == td) {
							if(nx < tx) {
								tx = nx;
								ty = ny;
								idx = i;
							}else if(nx == tx) {
								if(ny < ty) {
									tx = nx;
									ty = ny;
									idx = i;
								}
							}
						}
						continue outer;
					}
					q.offer(new int[] {nx, ny , c + 1});
					visited[nx][ny] = true;
				}
			}
		}
		if(td == Integer.MAX_VALUE) remain = false;
		else {
			fish.remove(idx);
			map[tx][ty] = 0;
			T += td;
			sx = tx;
			sy = ty;
			ecnt++;
			if(ecnt == shark) {
				shark++;
				ecnt = 0;
			}
		}
	}
}
