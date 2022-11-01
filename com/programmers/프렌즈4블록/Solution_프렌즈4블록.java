package com.programmers.프렌즈4블록;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_프렌즈4블록 {
	static char[][] map;
	static boolean[][] destroyed;
	static int M, N;
	static boolean completed;
	public static int solution(int m, int n, String[] board) {
        int answer = 0;
        M = m;
        N = n;
        map = new char[m][n];
        for(int i = 0; i < m; i++) {
        	map[i] = board[i].toCharArray();
        }
        completed = true;
        while(completed) {
        	completed = false;
        	destroyed = new boolean[m][n];
        	for(int i = 0; i < m; i++) {
        		for(int j = 0; j < n; j++) {
        			if(map[i][j] == '0' || i + 1 >= M || j + 1 >= N) continue;
        			check(i, j);
        		}
        	}
        	if(!completed) break;
        	drop();
        }
        for(int i = 0; i < M; i++) {
        	for(int j = 0; j < N; j++) {
        		if(map[i][j] == '0') answer++;
        	}
        }
        return answer;
    }
	private static void drop() {
		for(int j = 0; j < N; j++) {
			Queue<Character> q = new LinkedList<>();
			for(int i = M - 1; i >= 0; i--) {
				if(destroyed[i][j]) continue;
				q.offer(map[i][j]);
			}
			for(int i = M - 1; i >= 0; i--) {
				if(q.isEmpty()) map[i][j] = '0';
				else map[i][j] = q.poll();
			}
		}
	}
	private static void check(int i, int j) {
		if(map[i][j] == map[i][j + 1] && map[i][j] == map[i + 1][j] && map[i][j] == map[i + 1][j + 1]) {
			destroyed[i][j] = true;
			destroyed[i][j + 1] = true;
			destroyed[i + 1][j] = true;
			destroyed[i + 1][j + 1] = true;
			completed = true;
		}
	}
	public static void main(String[] args) {
		//System.out.println(solution(4, 5, new String[] {"CCBDE", "AAADE", "AAABF", "CCBBF"}));
		System.out.println(solution(6, 6, new String[] {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"}));
		System.out.println(solution(4, 5, new String[] {"AAAAA","AUUUA","AUUAA","AAAAA"}));
	}
}
