package com.programmers.야근지수;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution_야근지수 {
	public static long solution(int n, int[] works) {
		long answer = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
		for(int w : works) pq.offer(w);
		//Arrays.sort(works);
		int len = works.length;
		int idx = len - 1;
		while(n > 0) {
//			if(idx != 0 && works[idx] < works[idx - 1]) idx--;
//			if(works[idx] <= 0) break;
//			works[idx]--;
			int w = pq.poll();
			if(w == 0) break;
			pq.offer(w - 1);
			n--;
		}
//		for(int i = 0; i < len; i++) {
//			long w = works[i];
//			answer += w * w;
//		}
		while(!pq.isEmpty()) {
			int w = pq.poll();
			answer += w * w;			
		}
		return answer;
	}

	public static void main(String[] args) {
		System.out.println(solution(4, new int[] { 4, 3, 3 }));
		System.out.println(solution(1, new int[] { 2, 1, 2 }));
		System.out.println(solution(3, new int[] { 1, 1 }));
	}
}
