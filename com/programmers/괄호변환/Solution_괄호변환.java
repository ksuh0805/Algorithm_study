package com.programmers.괄호변환;

import java.util.Stack;

public class Solution_괄호변환 {
	public static String solution(String p) {
        String u = "";
        String v = "";
        if(isRight(p)) return p;
        int index = 0;
        int lcnt = 0;
        int rcnt = 0;
        for(int i = 0; i < p.length(); i++){
            if(p.charAt(i) == '(') lcnt++;
            else rcnt++;
            if(lcnt == rcnt) {
                index = i;
                break;
            }
        }
        
        u = p.substring(0, index + 1);
        v = p.substring(index + 1);
        if(isRight(u)) {
            return (u + solution(v));
        }else{
            String res = "(";
            res += solution(v) + ")";
            u = u.substring(1, u.length() - 1);
            for(int i = 0; i < u.length(); i++){
                if(u.charAt(i) == '(') res += ")";
                else res += "(";
            }
            return res;
        }
    }
    
    public static boolean isRight(String s){
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(') stack.push('(');
            else if(stack.isEmpty()) return false;
            else stack.pop();
        }
        if(stack.isEmpty()) return true;
        else return false;
    }
    public static void main(String[] args) {
		System.out.println(solution("(()())()"));
		System.out.println(solution(")("));
		System.out.println(solution("()))((()"));
	}
}
