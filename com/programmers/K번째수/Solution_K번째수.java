package com.programmers.K번째수;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution_K번째수 {
	public static int[] solution(int[] array, int[][] commands) {
		int len = commands.length;
        int[] answer = new int[len];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < len; i++) {
        	int first = commands[i][0] - 1;
        	int last = commands[i][1];
        	int k = commands[i][2];
        	for(int j = first; j < last; j++) {
        		pq.offer(array[j]);
        	}
        	for(int j = 0; j < k - 1; j++) {
        		pq.poll();
        	}
        	answer[i] = pq.poll();
        	pq.clear();
        }
        return answer;
    }
	public static void main(String[] args) {
		int[] array = {1, 5, 2, 6, 3, 7, 4};
		int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
		System.out.println(Arrays.toString(solution(array, commands)));
	}
}
