package com.programmers.단어변환;

import java.util.ArrayList;
import java.util.List;

public class Solution_단어변환 {
	static boolean[] visited;
	static String[] W;
	static int N, min;
	public static int solution(String begin, String target, String[] words) {
        N = words.length;
        W = new String[N];
        boolean exist = false;
        for(int i = 0; i < N; i++) {
        	W[i] = words[i];
        	if(words[i].equals(target)) exist = true;
        }
        if(!exist) return 0;
        min = 51;
        visited = new boolean[N];
        dfs(begin, target, 0);
        return min == 51 ? 0 : min;
    }
	
	private static void dfs(String begin, String target, int cnt) {
		if(begin.equals(target)) {
			min = Math.min(min, cnt);
			return;
		}
		cnt++;
		if(cnt > N) return;
		List<String> list = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			if(visited[i]) continue;
			int count = 0;
			String w = W[i];
			for(int j = 0; j < begin.length(); j++) {
				if(begin.charAt(j) != w.charAt(j)) count++;
			}
			if(count == 1) {
				list.add(w);
				visited[i] = true;
			}
		}
		for(int i = 0; i < list.size(); i++) {
			dfs(list.get(i), target, cnt);
		}
	}

	public static void main(String[] args) {
		System.out.println(solution("hit", "cog", new String[] {"hot", "dot", "dog", "lot", "log", "cog"}));
		System.out.println(solution("hit", "cog", new String[] {"hot", "dot", "dog", "lot", "log"}));
	}
}
