package com.programmers.주식가격;

import java.util.ArrayList;

public class Solution_주식가격 {
	public static int[] solution(int[] prices) {
		int[] answer = {};
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < prices.length; i++){
            int cur = prices[i];
            int t = 0;
            for(int j = i + 1; j < prices.length; j++){
                t++;
                if(cur > prices[j]) break;
            }
            list.add(t);
        }
        answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
	public static void main(String[] args) {
		int[] arr = solution(new int[] {1,2,3,2,3});
		for(int i : arr) System.out.print(i + " ");
	}
}
