package com.baekjoon.오르막길2846;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2846_오르막길 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] pi = new int[N];
		for(int i = 0; i < N; i++) {
			pi[i] = Integer.parseInt(st.nextToken());
		}
		int idx = 0;
		int max = 0;
		int cur = pi[0];
		for(int i = 1; i < N; i++) {
			if(cur < pi[i]) cur = pi[i];
			else {
				max = Math.max(max, pi[i - 1] - pi[idx]);
				idx = i;
				cur = pi[i];
			}
		}
		max = Math.max(max, pi[N - 1] - pi[idx]);
		System.out.println(max);
	}
}
