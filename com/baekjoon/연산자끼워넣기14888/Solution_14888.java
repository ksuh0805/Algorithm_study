package com.baekjoon.연산자끼워넣기14888;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution_14888 {
	static int n;
	static int min = Integer.MAX_VALUE;
	static int max = Integer.MIN_VALUE;
	static int[] operators, numbers;
	static boolean[] visited;
	static ArrayList<Integer> list = new ArrayList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		numbers = new int[n];
		operators = new int[n-1];
		visited = new boolean[n-1];
		for(int i = 0; i < n; i++) {
			numbers[i] = sc.nextInt();
		}
		// 덧셈, 뺄셈, 곱셈, 나눗셈
		for(int i = 0; i < 4; i++) {
			int num = sc.nextInt();
			while(num > 0) {
				list.add(i);
				num--;
			}
		}
		permutation(0);
		System.out.println(max);
		System.out.println(min);
	}
	public static void permutation(int depth) {
		if(depth == n - 1) {
			int result = 0;
			int a = numbers[0];
			int k = 0;
			for(int i = 1; i < n; i++) {
				int b = numbers[i];
				a = calc(k, a, b);
				k++;
			}
			result = a;
			max = Math.max(result, max);
			min = Math.min(result, min);
			return;
		}
		for(int i = 0; i < n - 1; i++) {
			if(!visited[i]) {
				visited[i] = true;
				operators[depth] = list.get(i);
				permutation(depth + 1);
				visited[i] = false;
			}
		}
	}
	public static int calc(int op, int a, int b) {
		if(operators[op] == 0) return a + b;
		else if(operators[op] == 1) return a - b;
		else if(operators[op] == 2) return a * b;
		else return a / b;
	}
}