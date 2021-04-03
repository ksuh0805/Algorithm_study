package com.baekjoon.탑2493;

import java.util.Scanner;
import java.util.Stack;

public class Solution_2493 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<Integer> stack = new Stack<>();
		Stack<Integer> temp = new Stack<>();
		int num = sc.nextInt();
		int[] towers = new int[num];
		for(int i = 0; i < num; i++) {
			stack.push(sc.nextInt());
		}
		int i = num;
		while(!stack.isEmpty()) {
			int tower = stack.pop();
			temp = (Stack<Integer>) stack.clone();
			int cnt = num;
			while(!temp.isEmpty()) {
				cnt--;
				if(temp.pop() >= tower) {
					break;
				}
			}
			towers[--i] = cnt;
			num--;
		}
		for(int j = 0; j < towers.length; j++) {
			System.out.print(towers[j] + " ");
		}

	}
}