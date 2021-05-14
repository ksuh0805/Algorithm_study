package com.baekjoon.가르침1062;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution_1062_가르침 {
	static int N, K, max;
	static Set<Character> hs, set;
	static boolean[] visited;
	static String[] ss, result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		if(K < 5) {
			System.out.println(0);
			return;
		}else if(K >= 26) {
			System.out.println(N);
			return;
		}
		ss = new String[N];
		visited = new boolean[26];
		for(int i = 0; i < N; i++) {
			String s = br.readLine();
			ss[i] = s.substring(4, s.length() - 4);
		}
		visited['a' - 97] = true;
		visited['n' - 97] = true;
		visited['t' - 97] = true;
		visited['i' - 97] = true;
		visited['c' - 97] = true;
		combination(0, 0);
		System.out.println(max);
	}
	private static void combination(int depth, int start) {
		if(depth == K - 5) {
			int count = 0;
			outer:
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < ss[i].length(); j++) {
					if(!visited[ss[i].charAt(j) - 97]) continue outer;
				}
				count++;
			}
			max = Math.max(max, count);
			return;
		}
		for(int i = 0; i < 26; i++) {
			if(!visited[i]) {
				visited[i] = true;
				combination(depth + 1, i + 1);
				visited[i] = false;				
			}
		}
	}
}
