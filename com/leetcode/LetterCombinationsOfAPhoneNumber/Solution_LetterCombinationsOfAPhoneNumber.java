package com.leetcode.LetterCombinationsOfAPhoneNumber;

import java.util.ArrayList;
import java.util.List;

public class Solution_LetterCombinationsOfAPhoneNumber {
	static int N;
	static int[] numbers;
	static int[] arr;
	static ArrayList<String> list;
	static char[][] phone = {{},{},{'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},{'m','n','o'},{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};
	public static List<String> letterCombinations(String digits) {
        char[] digit = digits.toCharArray();
        N = digit.length;
        numbers = new int[N];
        arr = new int[N];
        list = new ArrayList<>();
        if(digits.equals("")) return list;
        for(int i = 0; i < N; i++) {
        	numbers[i] = digit[i] - '0';
        }
        combination(0);
        return list;
    }
	private static void combination(int depth) {
		if(depth == N) {
			String result = "";
			for(int i = 0; i < N; i++) {
				result += phone[numbers[i]][arr[i]];
			}
			list.add(result);
			return;
		}
		for(int i = 0; i < 4; i++) {
			if(i == 3) {
				if(numbers[depth] != 7 && numbers[depth] != 9) continue;
			}
			arr[depth] = i;
			combination(depth + 1);
		}
	}
	public static void main(String[] args) {
		List<String> answer = letterCombinations("23");
		for(int i = 0; i < answer.size(); i++) {
			System.out.print(answer.get(i) + " ");
		}
		System.out.println();
		answer = letterCombinations("");
		for(int i = 0; i < answer.size(); i++) {
			System.out.print(answer.get(i) + " ");
		}
		System.out.println();
		answer = letterCombinations("2");
		for(int i = 0; i < answer.size(); i++) {
			System.out.print(answer.get(i) + " ");
		}
		System.out.println();
	}
}
