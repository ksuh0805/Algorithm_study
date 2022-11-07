package com.programmers.땅따먹기;

public class Solution_땅따먹기 {
	static int solution(int[][] land) {
        int n = land.length;
        for(int i = 1; i < n; i++) {
        	land[i][0] += Math.max(land[i - 1][1], Math.max(land[i - 1][2], land[i - 1][3]));
        	land[i][1] += Math.max(land[i - 1][0], Math.max(land[i - 1][2], land[i - 1][3]));
        	land[i][2] += Math.max(land[i - 1][0], Math.max(land[i - 1][1], land[i - 1][3]));
        	land[i][3] += Math.max(land[i - 1][0], Math.max(land[i - 1][1], land[i - 1][2]));
        }

        return Math.max(land[n - 1][0], Math.max(land[n - 1][1], Math.max(land[n - 1][2], land[n - 1][3])));
    }
	public static void main(String[] args) {
		System.out.println(solution(new int[][] {{1,2,3,5},{5,6,7,8},{4,3,2,1}}));
	}
}
