package com.swexpert.스도쿠검증1974;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution_1974 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int[][] sudoku = new int[9][9];
			Set<Integer> numbers = new HashSet<>();
			for(int i = 0; i < 9; i++) {
				for(int j = 0; j < 9; j++) {
					sudoku[i][j] = sc.nextInt();
				}
			}
			int answer = -1;
			for(int i = 0; i < 9; i++) {
				for(int j = 0; j < 9; j++) {
					numbers.add(sudoku[i][j]);
				}
				if(numbers.size() != 9) {
					answer = 0;
					break;
				}
				numbers.clear();
			}
			for(int i = 0; i < 9; i++) {
				if(answer == 0) break;
				for(int j = 0; j < 9; j++) {
					numbers.add(sudoku[j][i]);
				}
				if(numbers.size() != 9) {
					answer = 0;
					break;
				}
				numbers.clear();
			}
			for(int i = 0; i < 9; i += 3) {
				if(answer == 0) break;
				for(int j = 0; j < 9; j += 3) {
					for(int k = 0; k < 3; k++) {
						for(int l = 0; l < 3; l++) {
							numbers.add(sudoku[i + k][j + l]);							
						}
					}
					if(numbers.size() != 9) {
						answer = 0;
						break;
					}
					numbers.clear();
				}
			}
			if(answer == -1) answer = 1;
			
			System.out.println("#" + tc + " " + answer);
		}
	}
}
