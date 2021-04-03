package com.jungol.조커1205;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1205_조커 {
	static int n;
	static int cards[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		cards = new int[n];
		int joker = 0;
		for(int i = 0; i < n; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
			if(cards[i] == 0) joker++;
		}
		Arrays.sort(cards);
		int[] straight = new int[n];
		outer:
		for(int i = joker; i < n; i++) {
			int temp = joker;
			for(int j = i; j < n - 1; j++) {
				int cha  = cards[j + 1] - cards[j] - 1;
				if(cha > temp || cha < 0) {
					straight[i] = cards[j] + temp;
					continue outer;
				}
				else temp -= cha;
			}
			straight[i] = cards[n - 1] + temp;
		}
		int max = 0;
		for(int i = joker; i < n; i++) {
			max = Math.max(max, straight[i] - cards[i] + 1);
		}
		if(joker == n) max = n;
		System.out.println(max);
	}
}
