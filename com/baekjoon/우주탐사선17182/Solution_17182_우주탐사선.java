package com.baekjoon.우주탐사선17182;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Solution_17182_우주탐사선 {
	static int N, K, ans;
	static int[][] planets;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		planets = new int[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				planets[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                if (i == k)
                    continue; // 출발지와 경유지가 같다면 다음 출발지
                for (int j = 0; j < N; j++) {
                    if (i == j || k == j)
                        continue; // 경유지와 목적지가 같거나 출발지가 곧 목적지라면 패스
                    if (planets[i][j] > planets[i][k] + planets[k][j]) {
                    	planets[i][j] = planets[i][k] + planets[k][j];
                    }
                }
            }
        }
		ans = Integer.MAX_VALUE;
		visited = new boolean[N];
		visited[K] = true;
		dfs(K, 0, 0);
		System.out.println(ans);
	}
	private static void dfs(int start, int sum, int depth) {
		if(depth == N - 1) {
			ans = Math.min(ans, sum);
			return;
		}
		for(int i = 0; i < N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				dfs(i, sum + planets[start][i], depth + 1);
				visited[i] = false;
			}
		}
	}
}
