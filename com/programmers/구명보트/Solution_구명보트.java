package com.programmers.구명보트;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution_구명보트 {
	public static int solution(int[] people, int limit) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();
        for(int w : people) list.add(w);
        Collections.sort(list, Collections.reverseOrder());
        outer:
        for(int i = 0; i < list.size(); i++) {
        	int w = list.get(i);
        	if(w + list.get(list.size() - 1) <= limit) {
        		list.remove(list.size() - 1);
//        		answer++;
//        		continue outer;
        	}
//        	for(int j = i + 1; j < list.size(); j++) {
//        		if(w + list.get(j) <= limit) {
//        			list.remove(j);
//        			answer++;
//        			continue outer;
//        		}
//        	}
        	answer++;
        }
        return answer;
    }
	public static void main(String[] args) {
		System.out.println(solution(new int[] {70, 50, 80, 50}, 100));
		System.out.println(solution(new int[] {70, 80, 50}, 100));
	}
}
