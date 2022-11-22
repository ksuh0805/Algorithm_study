package com.programmers.쿼드압축후개수세기;

import java.util.Arrays;

public class Solution_쿼드압축후개수세기 {
	static int N;
	static int[] answer;
	static int[][] map;
	public static int[] solution(int[][] arr) {
        answer = new int[2];
        N = arr.length;
        if(N == 1) {
        	if(arr[0][0] == 0) answer[0] = 1;
        	else answer[1] = 1;
        	return answer;
        }
        map = new int[N][N];
        for(int i = 0; i < N; i++) {
        	for(int j = 0; j < N; j++) map[i][j] = arr[i][j];
        }
        int len = N;
        while(len >= 1) {
        	for(int i = 0; i < N; i += len) {
        		for(int j = 0; j < N; j += len) {
        			compress(i, j, len);
        		}
        	}
        	len /= 2;
        }
        return answer;
    }
	private static void compress(int x, int y, int len) {
		int n = map[x][y];
		if(n == 9) return;
		for(int i = x; i < x + len; i++) {
			for(int j = y; j < y + len; j++) {
				if(n != map[i][j]) return;
			}
		}
		for(int i = x; i < x + len; i++) {
			for(int j = y; j < y + len; j++) {
				map[i][j] = 9;
			}
		}
		if(n == 0) answer[0]++;
		else answer[1]++;
	}
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new int[][] {{1,1,0,0},{1,0,0,0},{1,0,0,1},{1,1,1,1}})));
		System.out.println(Arrays.toString(solution(new int[][] {{1,1,1,1,1,1,1,1},{0,1,1,1,1,1,1,1},{0,0,0,0,1,1,1,1},{0,1,0,0,1,1,1,1},{0,0,0,0,0,0,1,1},{0,0,0,0,0,0,0,1},{0,0,0,0,1,0,0,1},{0,0,0,0,1,1,1,1}})));
	}
}
