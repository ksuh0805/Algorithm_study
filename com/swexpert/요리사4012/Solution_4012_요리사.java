package com.swexpert.요리사4012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_4012_요리사 {
	static int N, min;
	static int[][] foods;
	static ArrayList<Integer> choiceA, choiceB;
	static int[] array;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			foods = new int[N][N];
			choiceA = new ArrayList<>();
			choiceB = new ArrayList<>();
			array = new int[N/2];
			min = Integer.MAX_VALUE;
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					foods[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			combination(0, 0);
			
			System.out.println("#" + tc + " " + min);
		}
	}
	private static void combination(int depth, int start) {
		if(depth == N/2) {
			for(int v : array) choiceA.add(v);
			for(int i = 0; i < N; i++) {
				if(!choiceA.contains(i)) {
					choiceB.add(i);
				}
			}
			int sumA = 0;
			int sumB = 0;
			for(int i = 0; i < N/2; i++) {
				int idxA = array[i];
				int idxB = choiceB.get(i);
				for(int j = i + 1; j < N/2; j++) {
					sumA += foods[idxA][array[j]];
					sumA += foods[array[j]][idxA];
					sumB += foods[idxB][choiceB.get(j)];
					sumB += foods[choiceB.get(j)][idxB];
				}
			}
			min = Math.min(min, Math.abs(sumA - sumB));
			choiceA.clear();
			choiceB.clear();
			return;
		}
		for(int i = start; i < N; i++) {
			array[depth] = i;
			combination(depth + 1, i + 1);
		}
	}
}
