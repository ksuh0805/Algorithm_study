package com.baekjoon.줄세우기2605;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2605_줄세우기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] line = new int[n];
		int[] num = new int[n];
		for(int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		for(int i = 0; i < n; i++) {
			int move = num[i];
			int k = i;
			for(int j = 0; j < move; j++) {
				line[k] = line[--k];
			}
			line[i - move] = i + 1;
		}
		for(int a : line) {
			System.out.print(a + " ");
		}
	}
}
