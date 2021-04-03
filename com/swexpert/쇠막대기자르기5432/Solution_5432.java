package com.swexpert.쇠막대기자르기5432;

import java.util.Scanner;
import java.util.Stack;

public class Solution_5432 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			char[] inputs = sc.next().toCharArray();
			Stack<Character> stack = new Stack<>();
			int count = 0;
			boolean flag = false;
			for(int i = 0; i < inputs.length; i++) {
				char c = inputs[i];
				if(c == '(') {
					stack.push('(');
					flag = false;
				}
				else {
					if(stack.peek() == ')') {
						stack.pop();
						flag = true;
						
					}
					else if(flag) {
						stack.pop();
						count++;
					}
					else {
						stack.pop();
						count += stack.size();
						flag = true;
					}
				}
			}
			System.out.println("#" + tc + " " + count);
		}
	}
}
