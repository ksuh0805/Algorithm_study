package com.baekjoon.캐슬디펜스17135;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution_17135 {
	static int n,m,d;
	static int max = 0;
	static int[] archer = new int[3];
	static int[][] map;
	
	static class loc implements Comparable<loc>{
		int x;
		int y;
		int d;
		public loc(int x, int y, int d) {
			super();
			this.x = x;
			this.y = y;
			this.d = d;
		}
		@Override
		public int compareTo(loc o) {
			int diff = this.d - o.d;
			return diff != 0 ? diff : this.y - o.y;
		}
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		d = sc.nextInt();
		map = new int[n][m];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		combination(0,0);
		System.out.println(max);
	}
	public static void combination(int depth, int start) {
		if(depth == 3) {
			max = Math.max(max, attack());
			return;
		}
		for(int i = start; i < m; i++) {
			archer[depth] = i;
			combination(depth + 1, i + 1);
		}
	}
	public static int attack() {
		int[][] temp = arraycopy(map);
		int count = 0;
		for(int i = 0; i < n; i++) { // 턴 돌기
			for(int j = 0; j < 3; j++) { 
				List<loc> enemy = new ArrayList<>();
				int a = archer[j]; // 궁수 위치 확인
					for(int k = n - 1; k >= 0; k--) { // 맨 아래부터 행 받기
						for(int l = 0; l < m; l++) { // 0열 부터 적 확인
							if(temp[k][l] != 0) {
								int dis = Math.abs(l - a) + n - k;
								if(dis <= d) {
									enemy.add(new loc(k, l, dis)); // 공격 가능한 거리 내 적
								}
							}
						}
					}
				
				if(enemy.isEmpty()) continue; // 적 없음
				Collections.sort(enemy);
				loc e = enemy.get(0); // 가장 가까운 적 위치
				if(temp[e.x][e.y] == 1) {
					temp[e.x][e.y] = -1;
					count++;
				}
			}
			temp = next(temp); // 행 하나씩 내리기
			// 적 없애기
			for(int k = n - 1; k >= 0; k--) {
				for(int l = 0; l < m; l++) {
					if(temp[k][l] == -1) {
						temp[k][l] = 0;
					}
				}
			}
		}
		return count;
	}
	public static int[][] next(int[][] arr) {
		for(int i = n - 1; i > 0; i--) {
			arr[i] = arr[i-1];
		}
		arr[0] = new int[m];
		return arr;
	}
	public static int[][] arraycopy(int[][] arr) {
		int[][] newArr = new int[n][m];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				newArr[i][j] = arr[i][j];
			}
		}
		return newArr;
	}
}
