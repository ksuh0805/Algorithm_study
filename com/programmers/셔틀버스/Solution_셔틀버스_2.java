package com.programmers.셔틀버스;

import java.util.PriorityQueue;

public class Solution_셔틀버스_2 {
	public static String solution(int n, int t, int m, String[] timetable) {
		int cur = 9 * 60;
		int last = cur + (n - 1) * t;
		int last_crew = 0;
		int cnt = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i = 0; i < timetable.length; i++) {
			String[] tt = timetable[i].split(":");
			pq.offer(Integer.parseInt(tt[0]) * 60 + Integer.parseInt(tt[1]));
		}
		while(!pq.isEmpty() && cur <= last) {
			cnt = 0;
			for(; cnt < m && !pq.isEmpty() && pq.peek() <= cur; cnt++) {
				last_crew = pq.poll();
			}
			cur += t;
		}
		return cnt == m ? timeToString(last_crew - 1) : timeToString(last);
	}
	private static String timeToString(int time) {
		StringBuilder sb = new StringBuilder();
		if(time / 60 < 10) sb.append("0");
		sb.append(time / 60);
		sb.append(":");
		if(time % 60 < 10) sb.append("0");
		sb.append(time % 60);
		return sb.toString();
	}
	public static void main(String[] args) {
		System.out.println(solution(1, 1, 5, new String[] {"08:00", "08:01", "08:02", "08:03"}));
		System.out.println(solution(2, 10, 2, new String[] {"09:10", "09:09", "08:00"}));
		System.out.println(solution(2, 1, 2, new String[] {"09:00", "09:00", "09:00", "09:00"}));
		System.out.println(solution(1, 1, 5, new String[] {"00:01", "00:01", "00:01", "00:01", "00:01"}));
		System.out.println(solution(1, 1, 1, new String[] {"23:59"}));
		System.out.println(solution(10, 60, 45, new String[] {"23:59","23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59"}));
	}
}
