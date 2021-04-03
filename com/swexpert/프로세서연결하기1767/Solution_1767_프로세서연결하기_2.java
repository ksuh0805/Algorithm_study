package com.swexpert.프로세서연결하기1767;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_1767_프로세서연결하기_2 {
	static int n, max, totalCnt, min, map[][];
	static ArrayList<int[]> list;
	static int dr[] = {-1, 1, 0, 0};
	static int dc[] = {0, 0, -1, 1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			list = new ArrayList<int[]>();
			max = 0;
			min = Integer.MAX_VALUE;
			totalCnt = 0;
			
			for(int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(i == 0 || j == 0 || i == n - 1 || j == n - 1) continue;
					if(map[i][j] == 1) {
						list.add(new int[] {i,j});
						totalCnt++;
					}
				}
			}
			
			connect(0, 0);
			
			System.out.println("#" + tc + " " + min);
		}
	}
	// index :부분집합에 고려할 코어 인덱스 , cCnt : 연결된 코어 개수
	private static void connect(int index, int cCnt) {
		
		if(index == totalCnt) {
			int res = getLength(); // 전선 길이 합
			if(max < cCnt) {
				max = cCnt;
				min = res;
			}else if(max == cCnt) {
				if(res < min) min = res;
			}
			return;
		}
		
		// 코어 선택 전선 놓기
		int[] cur = list.get(index);
		int r = cur[0];
		int c = cur[1];
		for(int d = 0; d < 4; d++) {
			if(isAvailable(r, c, d)) {
				// 전선 놓기
				setStatus(r, c, d, 2);
				// 다음 코어로 넘어가기
				connect(index + 1, cCnt + 1);
				// 놓았던 전선 되돌리기
				setStatus(r, c, d, 0);
			}
		}
		// 코어 비선택
		connect(index + 1, cCnt);
	}
	private static int getLength() {
		int lCnt = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(map[i][j] == 2) lCnt++;
			}
		}
		return lCnt;
	}
	private static void setStatus(int r, int c, int d, int s) {
		int nr = r; int nc = c;
		while(true) {
			nr += dr[d];
			nc += dc[d];
			if(nr < 0 || nr >= n || nc < 0 || nc >= n) break;
			map[nr][nc] = s;
		}
	}
	
	private static boolean isAvailable(int r, int c, int d) {
		int nr = r; int nc = c;
		while(true) {
			nr += dr[d];
			nc += dc[d];
			if(nr < 0 || nr >= n || nc < 0 || nc >= n) break;
			if(map[nr][nc] >= 1) return false;
		}
		return true;
	}
}
