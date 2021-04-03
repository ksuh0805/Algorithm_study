package com.swexpert.괄호짝짓기1218;

import java.util.Scanner;
import java.util.Stack;

public class Solution_1218 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int T = 1; T <= 10; T++) {
			Stack<Character> stack = new Stack<>();
			boolean flag = false;
			int ans = 0;
			
			int len = sc.nextInt();
			String s = sc.next();
			char[] inputs = s.toCharArray();
			for(int i = 0; i < len; i++) {
				char c = inputs[i];
				if(c == '(') stack.push('(');
				else if(c == '[') stack.push('[');
				else if(c == '{') stack.push('{');
				else if(c == ')') {
					if(stack.peek() != '(') {
//						flag = false;
						break;
					}
					else stack.pop();
				}
				else if(c == ']') {
					if(stack.peek() != '[') {
//						flag = false;
						break;
					}
					else stack.pop();
				}
				else if(c == '}') {
					if(stack.peek() != '{') {
//						flag = false;
						break;
					}
					else stack.pop();
				}
				if(stack.isEmpty()) flag = true;
				else flag = false;
			}
			
			
			if(flag) ans = 1;
			else ans = 0;
			System.out.println("#"+ T + " " + ans);
		}
	}
}
