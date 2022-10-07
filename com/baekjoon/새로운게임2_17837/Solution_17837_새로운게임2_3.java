package com.baekjoon.새로운게임2_17837;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class Solution_17837_새로운게임2_3 {
	static int N, K, T;
	static int[][] map;
	static ArrayList<Integer> [][] pieces;
	static Chess[] chs;
	static class Chess{
		int x, y, d;
		
		Chess(int x, int y, int d){
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st  = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N + 1][N + 1];
		pieces = new ArrayList[N + 1][N + 1];
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				pieces[i][j] = new ArrayList<>();
			}
		}
		chs = new Chess[K + 1];
		for(int i = 1; i <= K; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken()) - 1;
			chs[i] = new Chess(x, y, d);
			pieces[x][y].add(i);
		}
		while(T <= 1000) {
			T++;
			if(turn()) break;
		}
		System.out.println(T > 1000 ? -1 : T);
	}
	private static boolean turn() {
		for(int i = 1; i <= K; i++) {
			Chess ch = chs[i];
			int idx = -1;
			// 말 위치
			ArrayList<Integer> list = pieces[ch.x][ch.y];
			int size = list.size();
			for(int j = 0; j < size; j++) {
				if(list.get(j) == i) {
					idx = j;
					break;
				}
			}
			// 현재 위치 리스트
			Deque<Integer> dq = new ArrayDeque<>();
			for(int j = idx; j < size; j++) {
				dq.offer(list.get(j));
			}
			for(int j = idx; j < size; j++) {
				list.remove(idx);
			}
			// 이동 위치
			int nx = ch.x + dir[ch.d][0];
			int ny = ch.y + dir[ch.d][1];
			// 반대로
			if(nx <= 0 || nx > N || ny <= 0 || ny > N || map[nx][ny] == 2) {
				if(ch.d % 2 == 0) ch.d++;
				else ch.d--;
				nx = ch.x + dir[ch.d][0];
				ny = ch.y + dir[ch.d][1];
			}
			if(nx <= 0 || nx > N || ny <= 0 || ny > N || map[nx][ny] == 2) {
				while(!dq.isEmpty()) pieces[ch.x][ch.y].add(dq.poll());
				continue;
			}
			ArrayList<Integer> new_list = pieces[nx][ny];
			// 흰색
			if(map[nx][ny] == 0) {
				while(!dq.isEmpty()) new_list.add(dq.poll());
			// 빨간색
			}else {
				while(!dq.isEmpty()) new_list.add(dq.pollLast());
			}
			if(new_list.size() >= 4) return true;
			
			// 이동
			for(int j = 0; j < new_list.size(); j++) {
				int index = new_list.get(j);
				chs[index].x = nx;
				chs[index].y = ny;
			}
		}
		return false;
	}
	static int[][] dir = {{0,1},{0,-1},{-1,0},{1,0}};
}
