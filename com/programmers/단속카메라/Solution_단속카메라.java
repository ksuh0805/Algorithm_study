package com.programmers.단속카메라;

import java.util.Arrays;

public class Solution_단속카메라 {
	public static int solution(int[][] routes) {
        Arrays.sort(routes, (o1, o2) -> o1[1] - o2[1]);
        int cur = routes[0][1];
        int answer = 1;
        for(int i = 1; i < routes.length; i++) {
        	if(routes[i][0] > cur) {
        		cur = routes[i][1];
        		answer++;
        	}
        }
        return answer;
    }
	public static void main(String[] args) {
		System.out.println(solution(new int[][] {{-20,-15}, {-14,-5}, {-18,-13}, {-5,-3}}));
	}
}
