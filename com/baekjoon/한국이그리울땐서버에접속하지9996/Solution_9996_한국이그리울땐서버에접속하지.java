package com.baekjoon.한국이그리울땐서버에접속하지9996;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class Solution_9996_한국이그리울땐서버에접속하지 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		String s = br.readLine();
		int index = 0;
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == '*') {
				index = i;
				break;
			}
		}
		String pattern = s.substring(0, index) + "[a-z]" + s.substring(index, s.length());
		
		for(int i = 0; i < N; i++) {
			boolean result = Pattern.matches(pattern, br.readLine());
			if(result) System.out.println("DA");
			else System.out.println("NE");
		}
	}
}
