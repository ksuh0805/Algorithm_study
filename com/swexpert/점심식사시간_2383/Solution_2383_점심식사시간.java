package com.swexpert.점심식사시간_2383;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_2383_점심식사시간 {
	static int N, min;
	static int[][] map;
	static ArrayList<int[]> stairs;
	static ArrayList<int[]> people;
	static int[] order;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			stairs = new ArrayList<>();
			people = new ArrayList<>();
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());					
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] == 1) {
						people.add(new int[] {i, j, 0, 0});
					}else if(map[i][j] > 1) {
						stairs.add(new int[] {i, j, map[i][j]});
					}
				}
			}
			for(int i = 0; i < people.size(); i++) {
				int[] person = people.get(i);
				int[] stair1 = stairs.get(0);
				int[] stair2 = stairs.get(1);
				int a = Math.abs(stair1[0] - person[0]) + Math.abs(stair1[1] - person[1]);
				int b = Math.abs(stair2[0] - person[0]) + Math.abs(stair2[1] - person[1]);
				person[2] = a;
				person[3] = b;
			}
			min = Integer.MAX_VALUE;
			order = new int[people.size()];
			permutation(0);
			
			System.out.println("#" + tc + " " + min);
		}
	}
	private static void permutation(int depth) {
		if(depth == people.size()) {
			int t = simulation();
			min = Math.min(min, t);
			return;
		}
		for(int i = 0; i <= 2; i++) {
			order[depth] = i;
			permutation(depth + 1);
		}
	}
	private static int simulation() {
		int t = 0;
		int t1 = stairs.get(0)[2];
		int t2 = stairs.get(1)[2];
		boolean[] down = new boolean[people.size()];
		Queue<int[]> q1 = new LinkedList<>();
		Queue<int[]> q2 = new LinkedList<>();
		Queue<int[]> w1 = new LinkedList<>();
		Queue<int[]> w2 = new LinkedList<>();
		while(true) {
			t++;
			int size = q1.size();
			while(size > 0) {
				int[] p = q1.poll();
				if(p[1] <= 1) {
					if(!w1.isEmpty()) q1.offer(w1.poll());
				}else {
					p[1]--;
					q1.offer(p);
				}
				size--;
			}
			size = q2.size();
			while(size > 0) {
				int[] p = q2.poll();
				if(p[1] <= 1) {
					if(!w2.isEmpty()) q2.offer(w2.poll());
				}else {
					p[1]--;
					q2.offer(p);
				}
				size--;
			}
			/*
			while(!q2.isEmpty()) {
				if(q2.peek()[1] <= 1) {
					q2.poll();
					if(w2.isEmpty()) continue;
					q2.offer(w2.poll());
				}else {
					q2.peek()[1]--;
					break;
				}
			}
			*/
			
			for(int i = 0; i < people.size(); i++) {
				if(down[i]) continue;
				int[] p = people.get(i);
				int tt = order[i] == 0 ? p[2] : p[3];
				if(tt == t) {
					if(order[i] == 0) {
						if(q1.size() == 3) {
							w1.offer(new int[] {i, t1});
						}else {
							q1.offer(new int[] {i, t1});
						}
					}else {
						if(q2.size() == 3) {
							w2.offer(new int[] {i, t2});
						}else {
							q2.offer(new int[] {i, t2});
						}
					}
					down[i] = true;
				}
			}
			
			if(q1.isEmpty() && q2.isEmpty() && w1.isEmpty() && w2.isEmpty()) {
				boolean flag = true;
				for(int i = 0; i < people.size(); i++) {
					if(!down[i]) {
						flag = false;
						break;
					}
				}
				if(flag) break;
			}
		}
		return t + 1;
	}
}
