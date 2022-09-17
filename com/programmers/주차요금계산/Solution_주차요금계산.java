package com.programmers.주차요금계산;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution_주차요금계산 {
	public static int[] solution(int[] fees, String[] records) {
        Map<String, int[]> map = new HashMap<>();
        for(int i = 0; i < records.length; i++) {
        	String record = records[i];
        	String[] r = record.split(" ");
        	int h = Integer.parseInt(r[0].substring(0, 2));
        	int m = Integer.parseInt(r[0].substring(3));
        	int t = h * 60 + m;
        	if(r[2].equals("IN")) {
        		// {입차 시각, 누적 시간} 
        		int[] cur = map.getOrDefault(r[1], new int[] {0, 0});
        		cur[0] = t;
        		map.put(r[1], cur);
        	}else {
        		int[] cur = map.get(r[1]);
        		int in = cur[0];
        		int time = t - in;
        		cur[1] += time;
        		cur[0] = -1;
        		map.put(r[1], cur);
        	}
        }
        List<String> keySet = new ArrayList<>(map.keySet());
        Collections.sort(keySet);
        
        int last = 23 * 60 + 59;
        int[] answer = new int[keySet.size()];
        for(int i = 0; i < keySet.size(); i++) {
        	String k = keySet.get(i);
        	int[] res = map.get(k);
        	int time = res[0];
        	int total = res[1];
        	if(time != -1) {
        		total += last - time;
        	}
        	int cost = fees[1];
        	if(total > fees[0]) {
        		total -= fees[0];
    			int a = total / fees[2];
    			if(total % fees[2] != 0) a++;
    			cost += a * fees[3];
        	}
        	answer[i] = cost;
        }
        return answer;
    }
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new int[] {180, 5000, 10, 600}, new String[] {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"})));
		System.out.println(Arrays.toString(solution(new int[] {120, 0, 60, 591}, new String[] {"16:00 3961 IN","16:00 0202 IN","18:00 3961 OUT","18:00 0202 OUT","23:58 3961 IN"})));
		System.out.println(Arrays.toString(solution(new int[] {1, 461, 1, 10}, new String[] {"00:00 1234 IN"})));
	}
}
