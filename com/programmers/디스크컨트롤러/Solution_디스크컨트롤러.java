package com.programmers.디스크컨트롤러;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution_디스크컨트롤러 {
	public static int solution(int[][] jobs) {
	    int answer = 0;
	    int n = jobs.length;
	    Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
	    PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
	    int t = 0;
	    int cur = 0;
	    while(cur < n || !pq.isEmpty()) {
	    	while(cur < n && jobs[cur][0] <= t) pq.offer(jobs[cur++]);
	    	if(pq.isEmpty()) t = jobs[cur][0];
	    	else {
	    		int[] job = pq.poll();
	    		t += job[1];
	    		answer += t - job[0];
	    	}
	    }
	    return answer / n;
	}
	public static void main(String[] args) {
		System.out.println(solution(new int[][] {{0, 3}, {1, 9}, {2, 6}, {19, 2}}));
	}
}
