package com.programmers.합승택시요금;

public class Solution_합승택시요금 {
	public static void main(String[] args) {
		int[][] fares1 = {{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}};
		System.out.println(solution(6,4,6,2, fares1));
		System.out.println(solution(7,3,4,1, new int[][] {{5, 7, 9}, {4, 6, 4}, {3, 6, 1}, {3, 2, 3}, {2, 1, 6}}));
		System.out.println(solution(6,4,5,6, new int[][] {{2,6,6}, {6,3,7}, {4,6,7}, {6,5,11}, {2,5,12}, {5,3,20}, {2,4,8}, {4,3,9}}));
	}
	
	static public int solution(int n, int s, int a, int b, int[][] fares) {
	    int answer = Integer.MAX_VALUE;
	    int[][] map = new int[n + 1][n + 1];
	    for(int i = 0; i < fares.length; i++) {
	    	int[] f = fares[i];
	    	map[f[0]][f[1]] = f[2];
	    	map[f[1]][f[0]] = f[2];
	    }
	    for(int i = 1; i <= n; i++) {
	    	for(int j = 1; j <= n; j++) {
	    		if(i == j) continue;
	    		else if(map[i][j] == 0) map[i][j] = 100000001;
	    	}
	    }
	    for(int k = 1; k <= n; k++) {
		    for(int i = 1; i <= n; i++) {
		    	if(i == k) continue;
		    	for(int j = 1; j <= n; j++) {
	    			if(i == j || j == k) continue;
	    			if(map[i][j] > map[i][k] + map[k][j]) {
	    				map[i][j] = map[i][k] + map[k][j];
	    			}
	    		}
	    	}
	    }
	    for(int i = 1; i <= n; i++) {
	    	int sum = map[s][i];
	    	sum += map[i][a] + map[i][b];
	    	answer = Math.min(answer, sum);
	    }
	    return answer;
	}
}
