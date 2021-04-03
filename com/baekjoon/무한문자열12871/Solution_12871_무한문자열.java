package com.baekjoon.무한문자열12871;

import java.util.Scanner;

public class Solution_12871_무한문자열 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		String t = sc.next();
		int ans = 1;
		if(s.length() >= t.length()) {
			for(int i = 0; i < s.length(); i++) {
				int idx = i % t.length();
				if(s.charAt(i) != t.charAt(idx)) {
					ans = 0;
					break;
				}
			}
		}else {
			for(int i = 0; i < t.length(); i++) {
				int idx = i % s.length();
				if(s.charAt(idx) != t.charAt(i)) {
					ans = 0;
					break;
				}
			}
		}
		System.out.println(ans);
	}
}
