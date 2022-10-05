package com.programmers.방문길이;

public class Solution_방문길이 {
	static boolean[][][] visited;
	public static int solution(String dirs) {
        int answer = 0;
        visited = new boolean[11][11][4];
        char[] route = dirs.toCharArray();
        int x = 5;
        int y = 5;
        for(int i = 0; i < route.length; i++) {
        	char r = route[i];
        	int d = 0;
        	if(r == 'L') d = 1;
        	else if(r == 'U') d = 2;
        	else if(r == 'D') d = 3;
        	int nx = x + dir[d][0];
        	int ny = y + dir[d][1];
        	if(nx < 0 || ny < 0 || nx >= 11 || ny >= 11) continue;
        	if(!visited[x][y][d]) {
        		answer++;
        		visited[x][y][d] = true;
        		int nd = d;
        		if(d % 2 == 0) nd++;
        		else nd--;
        		visited[nx][ny][nd] = true;        		
        	}
        	x = nx;
        	y = ny;
        }
        
        return answer;
    }
	static int[][] dir = {{0,1},{0,-1},{-1,0},{1,0}};
	public static void main(String[] args) {
		System.out.println(solution("ULURRDLLU"));
		System.out.println(solution("LULLLLLLU"));
	}
}
