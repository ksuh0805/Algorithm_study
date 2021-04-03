package com.baekjoon.A와B12904;

import java.util.Scanner;

public class Solution_12904_A와B {
	static String S, T;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		S = sc.next();
		T = sc.next();
		
		addA(S);
		flipB(S);
		System.out.println(0);
	}
	private static void flipB(String S) {
		char[] arr = S.toCharArray();
		char[] reversed = new char[arr.length];
		for(int i = 0; i < arr.length; i++){ 
			reversed[arr.length - 1 - i] = arr[i];
		} 
		String reversedStr = new String(reversed);
		String temp = reversedStr + "B";
		if(temp.equals(T)) {
			System.out.println(1);
			System.exit(0);
		}
		if(temp.length() == T.length()) return;
		addA(temp);
		flipB(temp);
	}
	private static void addA(String S) {
		String temp = S + "A";
		if(temp.equals(T)) {
			System.out.println(1);
			System.exit(0);
		}
		if(temp.length() == T.length()) return;
		addA(temp);
		flipB(temp);
	}
}
