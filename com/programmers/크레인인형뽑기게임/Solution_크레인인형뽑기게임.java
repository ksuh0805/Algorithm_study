package com.programmers.크레인인형뽑기게임;

import java.util.Stack;

public class Solution_크레인인형뽑기게임 {
	public static void main(String[] args) {
		System.out.println(solution(new int[][] {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}}, new int[] {1,5,3,5,1,2,1,4}));
	}
	public static int solution(int[][] board, int[] moves) {
		int ans = 0;
		Stack<Integer> stack = new Stack<>();
		outer:
		for(int i = 0; i < moves.length; i++) {
			int n = moves[i] - 1;
			for(int k = 0; k < board.length; k++) {
				if(board[k][n] != 0) {
					if(stack.isEmpty()) stack.push(board[k][n]);
					else {
						if(stack.peek() == board[k][n]) {
							stack.pop();
							ans += 2;
						}
						else stack.push(board[k][n]);
					}
					board[k][n] = 0;
					continue outer;
				}
			}
		}
		return ans;
	}
}
