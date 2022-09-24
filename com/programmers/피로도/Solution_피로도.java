package com.programmers.피로도;

public class Solution_피로도 {
	static int N, K, max;
	static int[] order;
	static int[][] D;
	static boolean[] visited;
	public static int solution(int k, int[][] dungeons) {
        N = dungeons.length;
        K = k;
        D = dungeons;
        order = new int[N];
        visited = new boolean[N];
        permutation(0);
        return max;
    }
	private static void permutation(int depth) {
		if(depth == N) {
			int cur = K;
			int cnt = 0;
			for(int i = 0; i < N; i++) {
				int o = order[i];
				if(cur >= D[o][0]) {
					cur -= D[o][1];
					cnt++;
				}else break;
			}
			max = Math.max(max, cnt);
			return;
		}
		for(int i = 0; i < N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				order[depth] = i;
				permutation(depth + 1);
				visited[i] = false;
			}
		}
	}
	public static void main(String[] args) {
		System.out.println(solution(80, new int[][] {{80,20},{50,40},{30,10}}));
	}
}
