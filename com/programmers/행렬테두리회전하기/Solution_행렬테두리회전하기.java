package com.programmers.행렬테두리회전하기;

public class Solution_행렬테두리회전하기 {
	static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
	public static int[] solution(int rows, int columns, int[][] queries) {
		int[][] arr = new int[rows][columns];
		int num = 1;
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < columns; j++) arr[i][j] = num++;
		}
		int len = queries.length;
        int[] answer = new int[len];
        for(int i = 0; i < len; i++) {
        	int[] query = queries[i];
        	int x1 = query[0] - 1;
        	int y1 = query[1] - 1;
        	int x2 = query[2] - 1;
        	int y2 = query[3] - 1;
        	int min = arr[x1][y1];
        	int tmp = arr[x1][y1];
        	int x = x1;
        	int y = y1;
        	for(int d = 0; d < 4; d++) {
        		int nx = x + dir[d][0];
        		int ny = y + dir[d][1];
        		if(d == 0) {
        			if(nx > x2) continue;
        		}else if(d == 1) {
        			if(ny > y2) continue;
        		}else if(d == 2) {
        			if(nx < x1) continue;
        		}else if(d == 3) {
        			if(ny < y1) continue;
        		}
        		d--;
    			arr[x][y] = arr[nx][ny];
    			min = Math.min(min, arr[x][y]);
    			if(nx == x1 && ny == y1) arr[x][y] = tmp;
    			x = nx;
    			y = ny;
        	}
        	answer[i] = min;
        }
        return answer;
    }
	public static void main(String[] args) {
		int[] result = solution(6, 6, new int[][] {{2,2,5,4},{3,3,6,6},{5,1,6,3}});
		for(int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
		System.out.println();
		result = solution(3, 3, new int[][] {{1,1,2,2},{1,2,2,3},{2,1,3,2},{2,2,3,3}});
		for(int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
		System.out.println();
		result = solution(100, 97, new int[][] {{1,1,100,97}});
		for(int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
	}
}
