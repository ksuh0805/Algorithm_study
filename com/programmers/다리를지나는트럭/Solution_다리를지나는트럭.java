package com.programmers.다리를지나는트럭;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_다리를지나는트럭 {
	public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();
        int cur_weight = 0;
        for(int w : truck_weights) {
        	while(true) {
        		if(q.isEmpty()) {
        			q.offer(w);
        			cur_weight += w;
        			answer++;
        			break;
        		}else if(q.size() == bridge_length) {
        			cur_weight -= q.poll();
        		}else{
        			if(cur_weight + w > weight) {
        				q.offer(0);
        				answer++;
        			}else {
        				q.offer(w);
        				cur_weight += w;
        				answer++;
        				break;
        			}
        		}
        	}
        }
        return answer + bridge_length;
    }
	
	public static void main(String[] args) {
		int[] truck_weights = {7,4,5,6};
		System.out.println(solution(2, 10, truck_weights));
	}
}
