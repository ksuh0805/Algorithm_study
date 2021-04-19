package com.programmers.더맵게;

import java.util.PriorityQueue;

public class Solution_더맵게 {
	public static int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int s : scoville) {
        	pq.offer(s);
        }
        while(pq.peek() < K) {
        	if(pq.size() == 1) {
        		answer = -1;
        		break;
        	}
	        int last = pq.poll();
	        int second = pq.poll();
	        pq.offer(last + second * 2);
	        answer++;
        }
        return answer;
    }
	public static void main(String[] args) {
		int[] scoville = {1, 2, 3, 9, 10, 12};
		System.out.println(solution(scoville, 7));
	}
}
