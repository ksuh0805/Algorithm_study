package com.programmers.모의고사;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution_모의고사 {
	public static int[] solution(int[] answers) {
        int[] answer = {};
        int[] answer1 = {1,2,3,4,5};
        int[] answer2 = {2,1,2,3,2,4,2,5};
        int[] answer3 = {3,3,1,1,2,2,4,4,5,5};
        int anslen = answers.length;
        int one = 0;
        int two = 0;
        int three = 0;
        for(int i = 0; i < anslen; i++) {
        	int a = answers[i];
        	if(a == answer1[i % 5]) one++;
        	if(a == answer2[i % 8]) two++;
        	if(a == answer3[i % 10]) three++;
        }
        int max = Math.max(one, two);
        max = Math.max(max, three);
        ArrayList<Integer> list = new ArrayList<>();
        if(max == one) list.add(1);
        if(max == two) list.add(2);
        if(max == three) list.add(3);
        answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
        	answer[i] = list.get(i);
        }
        return answer;
    }
	public static void main(String[] args) {
		int[] answers = {1,2,3,4,5};
		System.out.println(Arrays.toString(solution(answers)));
		int[] answers2 = {1,3,2,4,2};
		System.out.println(Arrays.toString(solution(answers2)));
	}
}
