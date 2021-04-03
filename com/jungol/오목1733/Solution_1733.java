package com.jungol.오목1733;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1733 {
	static int[][] omok = new int[19][19];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i = 0; i < 19; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 19; j++) {
				omok[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int ans = 0;
		int x = 0;
		int y = 0;
		outer :
		for(int i = 0; i < 19; i++) {
			for(int j = 0; j < 19; j++) {
				if(omok[i][j] != 0) {
					if(check(i, j)) {
						ans = omok[i][j];
						x = i + 1;
						y = j + 1;
						break outer;
					}
				}
			}
		}
		System.out.println(ans);
		if(ans != 0) System.out.println(x + " " + y);
	}
	static int[][] dir = {{-1, 1}, {0, 1}, {1, 1}, {1, 0}};
	private static boolean check(int x, int y) {
		for(int i = 0; i < 4; i++) {
			int nx = x;
			int ny = y;
			int count = 1;
			for(int j = 0; j < 5; j++) {
				nx += dir[i][0];
				ny += dir[i][1];
				if(nx < 0 || nx >= 19 || ny < 0 || ny >= 19) break;
				if(omok[x][y] != omok[nx][ny]) break;
				count++;
			}
			if(count == 5) {
				nx = x - dir[i][0];
				ny = y - dir[i][1];
				if(nx < 0 || nx >= 19 || ny < 0 || ny >= 19) return true;
				else if(omok[x][y] == omok[nx][ny]) continue;
				return true;
			}
		}
		return false;
	}
}
