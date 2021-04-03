package com.baekjoon.참외밭2477;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2477_참외밭 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		int[] bat = new int[7];
		for(int i = 0; i < 6; i++) {
			String s = br.readLine();
			if(s == null) break;
			StringTokenizer st = new StringTokenizer(s);
			int d = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			bat[i] = l;
		}
		int w = 0;
		int h = 0;
		int area = 0;
		for(int i = 0; i < 6; i++) {
			if(i % 2==0) w = Math.max(w, bat[i]);
			else h = Math.max(h, bat[i]);
			area += bat[i] * bat[i + 1];
		}
		area += bat[0] * bat[5];
		System.out.println((area - 2 * w * h) * k);
	}
}
