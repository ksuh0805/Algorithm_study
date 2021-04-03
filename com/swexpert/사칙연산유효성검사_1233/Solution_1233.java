package com.swexpert.사칙연산유효성검사_1233;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_1233 {
	static char[] chars;
	static int height;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int T = 1; T <= 10; T++) {
			int n = sc.nextInt();
			height = (int)(Math.log(n + 1) / Math.log(2));
			chars = new char[n];
			Queue<Character> queue = new LinkedList<>();
			for(int i = 0; i < n; i++) {
				int k = sc.nextInt();
				chars[i] = sc.next().charAt(0);
			}
		}
	}
}
