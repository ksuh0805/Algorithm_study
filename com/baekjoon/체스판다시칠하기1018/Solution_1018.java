package com.baekjoon.체스판다시칠하기1018;

import java.util.Scanner;

public class Solution_1018 {
	static final char[][] white = {
			{'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
			{'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
			{'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
			{'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
			{'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
			{'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
			{'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
			{'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'}
	};
	
	static final char[][] black = {
			{'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
			{'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
			{'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
			{'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
			{'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
			{'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
			{'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
			{'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'}
	};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] dir = { {-1,0}, {1,0}, {-1,0}, {0,1}};
		char[][] board = new char[n][m];
		
		for(int i = 0; i < n; i++) {
			String s = sc.next();
			board[i] = s.toCharArray();
		}
		int min = Integer.MAX_VALUE;
		for(int i = 0; i <= n - 8; i++) {
			for(int j = 0; j <= m - 8; j++) {
				int count1 = 0;
				int count2 = 0;
				int x = i;
				int y = j;
				for(int k = x; k < x + 8; k++) {
					for(int l = y; l < y + 8; l++) {
						char c = board[k][l];
						if(c != white[k-i][l-j]) count1++;
						if(c != black[k-i][l-j]) count2++;
						
					}
				}
				if(min > count1) min = count1;
				if(min > count2) min = count2;
			}
		}
		System.out.println(min);
	}
}
