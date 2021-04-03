package com.baekjoon.빙고_2578;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2578_빙고 {
	static int[][] map = new int[5][5];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 5; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int target = 0;
		outer :
		for(int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 5; j++) {
				int n = Integer.parseInt(st.nextToken());
				search(n);
				if(n >= 2) {
					if(check()) {
						target = 5 * i + j + 1;
						break outer;
					}
				}
			}
		}
		System.out.println(target);
	}
	private static boolean check() {
		int rcnt = 0;
		int ccnt = 0;
		int dcnt = 0;
		loop1:
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				if(map[i][j] != -1) continue loop1;
			}
			rcnt++;
		}
		loop2:
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				if(map[j][i] != -1) continue loop2;
			}
			ccnt++;
		}
		int temp = 0;
		for(int i = 0, j = 0; i < 5 & j < 5; i++, j++) {
			if(map[i][j] != -1) break;
			else temp++;
		}
		if(temp == 5) dcnt++;
		temp = 0;
		for(int i = 0, j = 4; i < 5 & j >= 0; i++, j--) {
			if(map[i][j] != -1) break;
			else temp++;
		}
		if(temp == 5) dcnt++;
		
		if(rcnt + ccnt + dcnt >= 3) return true;
		else return false;
	}
	public static void search(int n) {
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				if(map[i][j] == n) map[i][j] = -1;
			}
		}
	}
}
