package com.programmers.짝지어제거하기;

import java.util.Stack;

public class Solution_짝지어제거하기 {
	public static int solution(String s) {
		Stack<Character> stack = new Stack<>();
		stack.push(s.charAt(0));
		for(int i = 1; i < s.length(); i++) {
			char c = stack.peek();
			char k = s.charAt(i);
			if(c == k) {
				stack.pop();
				if(stack.size() == 0 && i < s.length() - 1) {
					stack.push(s.charAt(++i));
				}
			}else {
				stack.push(k);
			}
		}
		if(stack.size() > 0) return 0;
		else return 1;
	}
	public static void main(String[] args) {
		System.out.println(solution("baabaa"));
		System.out.println(solution("cdcd"));
	}
}
