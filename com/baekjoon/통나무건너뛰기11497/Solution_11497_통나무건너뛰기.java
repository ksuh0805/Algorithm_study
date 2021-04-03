package com.baekjoon.통나무건너뛰기11497;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_11497_통나무건너뛰기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] list = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				list[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(list);
			int[] newlist = new int[N];
			for(int i = 0, k = 0; i < N; i+=2, k++) {
				newlist[k] = list[i];
				if(i + 1 == N) break;
				newlist[N-1-k] = list[i + 1];
			}
			//System.out.println(Arrays.toString(newlist));
			int max = 0;
			for(int i = 0; i < N - 1; i++) {
				int cha = Math.abs(newlist[i] - newlist[i + 1]);
				max = Math.max(max, cha);
			}
			System.out.println(max);
		}
	}
}
