package com.baekjoon.청소년상어_19236;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution_청소년상어_2 {
	static int max;
	static int[][] dir = { { 0, 0 }, { -1, 0 }, { -1, -1 }, { 0, -1 }, { 1, -1 }, { 1, 0 }, { 1, 1 }, { 0, 1 },
			{ -1, 1 } };
	static class Fish{
		int n, d;
		Fish(int n, int d){
			this.n = n;
			this.d = d;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Fish[][] map = new Fish[4][4];
		Map<Integer, int[]> fishes = new HashMap<>();
		for (int i = 0; i < 4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				int n = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
				map[i][j] = new Fish(n, d);
				fishes.put(n, new int[] {i, j});
			}
		}
		max = 0;
		int sx = 0;
		int sy = 0;
		int sd = map[0][0].d;
		max += map[0][0].n;
		fishes.put(map[0][0].n, new int[] {-1, -1});
		map[0][0].n = 0;
		fmove(sx, sy, sd, fishes, map, max);
		System.out.println(max);
	}

	private static void fmove(int sx, int sy, int sd, Map<Integer, int[]> fishes, Fish[][] map, int sum) {
		for (int i = 1; i <= 16; i++) {
			int[] cur = fishes.get(i);
			if (cur[0] == -1) continue;
			int x = cur[0];
			int y = cur[1];
			int d = map[x][y].d;
			for (int k = 0; k < 8; k++) {
				int dd = d + k;
				if (dd > 8)	dd -= 8;
				int nx = x + dir[dd][0];
				int ny = y + dir[dd][1];
				if (nx < 0 || nx >= 4 || ny < 0 || ny >= 4)	continue;
				if (nx == sx && ny == sy) continue;
				if (map[nx][ny].n == 0) {
					fishes.put(i, new int[] { nx, ny });
					map[nx][ny].n = i;
					map[x][y].n = 0;
					map[nx][ny].d = dd;
					map[x][y].d = 0;
				} else {
					fishes.put(i, new int[] { nx, ny });
					fishes.put(map[nx][ny].n, new int[] { x, y });
					map[x][y].n = map[nx][ny].n;
					map[nx][ny].n = i;
					map[x][y].d = map[nx][ny].d;
					map[nx][ny].d = dd;
				}
				break;
			}
		}
		smove(sx, sy, sd, fishes, map, sum);
	}

	private static void smove(int sx, int sy, int sd, Map<Integer, int[]> fishes, Fish[][] map, int sum) {
		boolean flag = false;
		for(int i = 1; i <= 3; i++) {
			Map<Integer, int[]> temps = new HashMap<>();
			Fish[][] temp = new Fish[4][4];
			for(int j = 1; j <= 16; j++) {
				int[] xy = new int[2];
				xy[0] = fishes.get(j)[0];
				xy[1] = fishes.get(j)[1];
				temps.put(j, xy);
			}
			for(int j = 0; j < 4; j++) {
				for(int k = 0; k < 4; k++) {
					Fish f = new Fish(map[j][k].n , map[j][k].d);
					temp[j][k] = f;
				}
			}
			int nx = sx + dir[sd][0] * i;
			int ny = sy + dir[sd][1] * i;
			if(nx < 0 || nx >= 4 || ny < 0 || ny >= 4) break;
			if(map[nx][ny].n == 0) continue;
			int nn = map[nx][ny].n;
			flag = true;
			temp[nx][ny].n = 0;
			temps.put(map[nx][ny].n, new int[] {-1, -1});
			fmove(nx, ny, map[nx][ny].d, temps, temp, sum + nn);
		}
		if(!flag) {
			max = Math.max(max, sum);
		}
	}
}
