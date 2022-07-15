package com.programmers.괄호회전하기;

import java.util.Stack;

public class Solution_괄호회전하기 {
	static String S;
	public static int solution(String s) {
        int answer = 0;
        if(s.length() % 2 == 1) return answer;
        S = s;
        for(int i = 0; i < s.length(); i++) {
        	if(check(i)) answer++;
        }
        return answer;
    }
	private static boolean check(int x) {
		Stack<Character> stack = new Stack<>();
		String ss = S.substring(x) + S.substring(0, x);
		char[] cs = ss.toCharArray();
		for(int i = 0; i < cs.length; i++) {
			char c = cs[i];
			if(c == '[' || c == '(' || c == '{') stack.push(c);
			else if(c == ']') {
				if(stack.isEmpty()) return false;
				if(stack.peek() == '[') stack.pop();
				else return false;
			}
			else if(c == ')') {
				if(stack.isEmpty()) return false;
				if(stack.peek() == '(') stack.pop();
				else return false;
			}
			else if(c == '}') {
				if(stack.isEmpty()) return false;
				if(stack.peek() == '{') stack.pop();
				else return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		System.out.println(solution("[](){}"));
		System.out.println(solution("}]()[{"));
		System.out.println(solution("[)(]"));
		System.out.println(solution("}}}"));
	}
}
