package com.programmers.정수삼각형;

public class Solution_정수삼각형 {
	public static int solution(int[][] triangle) {
        int len = triangle.length;
        int[][] dTriangle = new int[len][len];
        dTriangle[0][0] = triangle[0][0];
        for(int i = 1; i < len; i++) {
        	dTriangle[i][0] = dTriangle[i - 1][0] + triangle[i][0];
        	dTriangle[i][i] = dTriangle[i - 1][i - 1] + triangle[i][i];
        }
        for(int i = 1; i < len; i++) {
        	for(int j = 1; j < i + 1; j++) {
        		dTriangle[i][j] = Math.max(dTriangle[i - 1][j - 1], dTriangle[i - 1][j]) + triangle[i][j];
        	}
        }
        int max = 0;
        for(int i = 0; i < len; i++) {
        	max = Math.max(max, dTriangle[len - 1][i]);
        }
        return max;
    }
	public static void main(String[] args) {
		int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
		System.out.println(solution(triangle));
	}
}
