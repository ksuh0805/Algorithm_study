package com.programmers.전력망을둘로나누기;

public class Solution_전력망을둘로나누기 {
	static int[][] map;
	static int N, W, min, A;
	static boolean[] visited;
	public static int solution(int n, int[][] wires) {
        min = Integer.MAX_VALUE;
        N = n;
        W = wires.length;
        for(int i = 0; i < W; i++) {
        	map = new int[N + 1][N + 1];
        	for(int j = 0; j < W; j++) {
        		if(i == j) continue;
        		int[] wire = wires[j];
        		int a = wire[0];
        		int b = wire[1];
        		map[a][b] = map[b][a] = 1;        		
        	}
        	A = 0;
        	visited = new boolean[N + 1];
        	dfs(1);
        	min = Math.min(min, Math.abs(N - (2 * A)));
        }
        return min;
    }
	private static void dfs(int current) {
		if(visited[current]) return;
		visited[current] = true;
		A++;
		for(int i = 1; i <= N; i++) {
			if(map[current][i] == 1 && !visited[i]) dfs(i);
		}
	}
	public static void main(String[] args) {
		System.out.println(solution(9, new int[][] {{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}}));
		System.out.println(solution(4, new int[][] {{1,2},{2,3},{3,4}}));
		System.out.println(solution(7, new int[][] {{1,2},{2,7},{3,7},{3,4},{4,5},{6,7}}));
	}
}
