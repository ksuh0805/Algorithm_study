package com.programmers.가장큰수;

import java.util.Arrays;

public class Solution_가장큰수 {
	public static String solution(int[] numbers) {
        String answer = "";
        String[] ss = new String[numbers.length];
        for(int i = 0; i < numbers.length; i++) {
        	ss[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(ss, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        if (ss[0].equals("0")) {
			return "0";
		}
        for(String s : ss){
            answer += s;
        }
        return answer;
    }
	public static void main(String[] args) {
		System.out.println(solution(new int[] {6, 10, 2}));
		System.out.println(solution(new int[] {3, 30, 34, 5, 9}));
	}
}
