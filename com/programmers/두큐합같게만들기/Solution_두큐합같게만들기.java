package com.programmers.두큐합같게만들기;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_두큐합같게만들기 {
	public static void main(String[] args) {
		System.out.println(solution(new int[] { 3, 2, 7, 2 }, new int[] { 4, 6, 5, 1 }));
		System.out.println(solution(new int[] { 1, 2, 1, 2 }, new int[] { 1, 10, 1, 2 }));
		System.out.println(solution(new int[] { 1, 1 }, new int[] { 1, 5 }));
	}

	public static int solution(int[] queue1, int[] queue2) {
		int answer = -1;
		long sum = 0;
		long sum1 = 0;
		long sum2 = 0;
		int n = queue1.length;
		Queue<Integer> q1 = new LinkedList<>();
		Queue<Integer> q2 = new LinkedList<>();
		for(int i = 0; i < n; i++) {
			q1.offer(queue1[i]);
			q2.offer(queue2[i]);
			sum1 += queue1[i];
			sum2 += queue2[i];
		}
		sum = sum1 + sum2;
		sum /= 2;
		int cnt = 0;
		while(true) {
			if(cnt == n * 3) break;
			if(sum1 == sum && sum2 == sum) {
				answer = cnt;
				break;
			}else if(sum1 > sum2) {
				int n1 = q1.poll();
				q2.offer(n1);
				sum1 -= n1;
				sum2 += n1;
			}else if(sum1 < sum2) {
				int n2 = q2.poll();
				q1.offer(n2);
				sum1 += n2;
				sum2 -= n2;
			}
			cnt++;
		}
		return answer;
	}
}
