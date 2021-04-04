package com.baekjoon.단어나누기1251;

import java.util.Scanner;

public class Solution_1251_단어나누기 {
	static String word, result;
	static int[] divide;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		word = sc.next();
		result = "";
		divide = new int[2];
		combination(0,0);
		System.out.println(result);
	}
	private static void combination(int depth, int start) {
		if(depth == 2) {
			String s1 = reverse(word.substring(0, divide[0] + 1));
			String s2 = reverse(word.substring(divide[0] + 1, divide[1] + 1));
			String s3 = reverse(word.substring(divide[1] + 1));
			String newWord = s1 + s2 + s3;
			if(result.equals("")) {
				result = newWord;
			}else {
				if(result.compareTo(newWord) > 0) result = newWord;
			}
			return;
		}
		for(int i = start; i < word.length() - 1; i++) {
			divide[depth] = i;
			combination(depth + 1, i + 1);
		}
	}
	private static String reverse(String str) {
		char[] arr = str.toCharArray();
		char[] reversedArr = new char[arr.length];
		for(int i = 0; i < arr.length; i++){
			reversedArr[arr.length - 1 - i] = arr[i]; 
		} 
		String reversedStr = new String(reversedArr); 
		//System.out.println(reversedStr);

		return reversedStr;
	}
}
