package com.programmers.수식최대화;

import java.util.ArrayList;

public class Solution_수식최대화 {
	static ArrayList<Integer> numbers;
	static ArrayList<Character> operators;
	static char[] expr;
	static char[][] prior = {{'+', '-', '*'}, {'+', '*', '-'}, {'-', '+', '*'}, 
							{'-', '*', '+'}, {'*', '-', '+'}, {'*', '+', '-'}};
	static String Exp;
	static long max;
	public static long solution(String expression) {
		Exp = expression;
		expr = expression.toCharArray();
		max = 0;
		stack();
		for(int i = 0; i < 6; i++) {
			calc(i);
		}
		return max;
	}
	private static void calc(int k) {
		char[] p = prior[k];
		ArrayList<Integer> nums = new ArrayList<>(numbers);
		ArrayList<Character> ops = new ArrayList<>(operators);
		int index = 0;
		for(int i = 0, j = 0; i < ops.size(); i++, j++) {
			char op = ops.get(i);
			int a = nums.get(j);
			int res = 0;
			if(op == p[index]) {
				int b = nums.get(j + 1);
				if(op == '+') res = b + a;
				else if(op == '-') res = a - b;
				else res = a * b;
				nums.remove(j);
				nums.remove(j);
				nums.add(j, res);
				ops.remove(i);
				i--;
				j--;
			}
			if(i >= ops.size() - 1) {
				if(index == 2) break;
				index++;
				i = -1;
				j = -1;
			}
		}
		int result = Math.abs(nums.get(0));
		max = Math.max(max, result);
	}
	public static void stack() {
		numbers = new ArrayList<>();
		operators = new ArrayList<>();
		
		int index = 0;
		for(int i = 0; i < expr.length; i++) {
			if(!Character.isDigit(expr[i])) {
				int num = Integer.parseInt(Exp.substring(index, i));
				numbers.add(num);
				operators.add(expr[i]);
				index = i + 1;
			}else if(i == expr.length - 1) {
				int num = Integer.parseInt(Exp.substring(index, i + 1));
				numbers.add(num);
			}
		}
	}
	public static void main(String[] args) {
		System.out.println(solution("100-200*300-500+20"));
		System.out.println(solution("50*6-3*2"));
	}
}
