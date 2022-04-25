package com.programmers.로또의최고순위와최저순위;

import java.util.ArrayList;

public class Solution_로또의최고순위와최저순위 {
	public static int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        ArrayList<Integer> list = new ArrayList<>();
        for(int i : win_nums) {
        	list.add(i);
        }
        int cnt = 0;
        int blind = 0;
        for(int n : lottos) {
        	if(n == 0) blind++;
        	else if(list.contains(n)) cnt++;
        }
        int high = cnt + blind;
        int low = cnt;
        answer[0] = rank(high);
        answer[1] = rank(low);
        return answer;
    }
	public static int rank(int num) {
		switch(num) {
			case 6: return 1;
			case 5 : return 2;
			case 4 : return 3;
			case 3 : return 4;
			case 2 : return 5;
			default : return 6;
		}
			
	}
	public static void main(String[] args) {
		int[] result = new int[2];
		result = solution(new int[] {44, 1, 0, 0, 31, 25}, new int[] {31, 10, 45, 1, 6, 19});
		for(int i = 0; i < 2; i++) {
			System.out.print(result[i] + " ");
		}
		System.out.println();
		result = solution(new int[] {0, 0, 0, 0, 0, 0}, new int[] {38, 19, 20, 40, 15, 25});
		for(int i = 0; i < 2; i++) {
			System.out.print(result[i] + " ");
		}
		System.out.println();
		result = solution(new int[] {45, 4, 35, 20, 3, 9}, new int[] {20, 9, 3, 45, 4, 35});
		for(int i = 0; i < 2; i++) {
			System.out.print(result[i] + " ");
		}
	}
}
