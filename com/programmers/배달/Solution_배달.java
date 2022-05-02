package com.programmers.배달;

import java.util.Arrays;

public class Solution_배달 {
	public static int solution(int N, int[][] road, int K) {
        int answer = 0;
        int[][] map = new int[N + 1][N + 1];
        for(int i = 0; i < road.length; i++) {
        	int a = road[i][0];
        	int b = road[i][1];
        	int d = road[i][2];
        	if(map[a][b] != 0) {
        		map[a][b] = map[b][a] = Math.min(map[a][b], d);
        	}else {
        		map[a][b] = map[b][a] = d;
        	}
        }
        int[] distance = new int[N + 1];
        boolean[] visited = new boolean[N + 1];
        
        Arrays.fill(distance, Integer.MAX_VALUE);
        
        distance[1] = 0;
        for(int i = 1; i < N + 1; i++) {
        	int min = Integer.MAX_VALUE;
        	int cur = 1;
        	for(int j = 1; j < N + 1; j++) {
        		if(!visited[j] && min > distance[j]) {
        			min = distance[j];
        			cur = j;
        		}
        	}
        	visited[cur] = true;
        	
        	for(int j = 1; j < N + 1; j++) {
        		if(!visited[j] && map[cur][j] != 0 && distance[j] > min + map[cur][j]) {
        			distance[j] = min + map[cur][j];
        		}
        	}
        }
        for(int i = 1; i < N + 1; i++) {
        	if(distance[i] <= K) answer++;
        }

        return answer;
    }
	
	public static void main(String[] args) {
		System.out.println(solution(5, new int[][] {{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}},3));
		System.out.println(solution(6, new int[][] {{1,2,1},{1,3,2},{2,3,2},{3,4,3},{3,5,2},{3,5,3},{5,6,1}},4));
	}
}
