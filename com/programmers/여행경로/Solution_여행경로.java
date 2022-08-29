package com.programmers.여행경로;

import java.util.ArrayList;
import java.util.Collections;

public class Solution_여행경로 {
	static int N;
	static boolean[] visited;
	static String[][] Ts;
	static ArrayList<String> result;
	public static String[] solution(String[][] tickets) {
		N = tickets.length;
        visited = new boolean[N];
        result = new ArrayList<>();
        Ts = tickets;
        dfs("ICN", "ICN", 0);
        Collections.sort(result);
        return result.get(0).split(" ");
    }
	private static void dfs(String start, String route, int depth) {
		if(depth == N) {
			result.add(route);
		}
		for(int i = 0; i < N; i++) {
			if(start.equals(Ts[i][0]) && !visited[i]) {
				visited[i] = true;
				dfs(Ts[i][1], route + " " + Ts[i][1], depth + 1);
				visited[i] = false;
			}
		}
	}
	public static void main(String[] args) {
		String[] arr = solution(new String[][] {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}});
		for(String s : arr) {
			System.out.print(s + " ");
		}
		System.out.println();
		arr = solution(new String[][] {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}});
		for(String s : arr) {
			System.out.print(s + " ");
		}
		System.out.println();
		arr = solution(new String[][] {{"ICN", "A"}, {"ICN", "B"}, {"B", "ICN"}});
		for(String s : arr) {
			System.out.print(s + " ");
		}
	}
}
