package com.programmers.기능개발;

import java.util.LinkedList;
import java.util.List;

public class Solution_기능개발 {
	public static int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        int len = progresses.length;
        int[] times = new int[len];
        for(int i = 0; i < len; i++) {
        	times[i] = (100 - progresses[i]) / speeds[i];
        	if((100 - progresses[i]) % speeds[i] != 0) times[i]++;
        }
        int cnt = 1;
        int cur = times[0];
        List<Integer> list = new LinkedList<>();
        for(int i = 1; i < len; i++) {
        	if(cur >= times[i]) cnt++;
        	else {
        		list.add(cnt);
        		cur = times[i];
        		cnt = 1;
        	}
        }
        list.add(cnt);
        answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
        	answer[i] = list.get(i);
        }
        return answer;
    }
	public static void main(String[] args) {
		int[] res = solution(new int[] {93, 30, 55}, new int[] {1, 30, 5});
		for(int i = 0; i < res.length; i++) {
			System.out.print(res[i] + " ");
		}
		System.out.println();
		res = solution(new int[] {95, 90, 99, 99, 80, 99}, new int[] {1, 1, 1, 1, 1, 1});
		for(int i = 0; i < res.length; i++) {
			System.out.print(res[i] + " ");
		}
	}
}
