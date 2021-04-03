package com.swexpert.ladder1_1210;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution_1210 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("/Users/suhyun/SSAFY/workspace/Algorithm/src/com/swexpert/ladder1_1210/input.txt")); // 파일 입출력
		Scanner sc = new Scanner(System.in);
		
		for(int tc = 1; tc <= 10; tc++) {
			int T = sc.nextInt();
			int x = 0;
			int[][] arr = new int[100][100];
			for(int i = 0; i < 100; i++) {
				for(int j = 0; j < 100; j++) arr[i][j] = sc.nextInt();
			}
			for(int i = 0; i < 100; i++) {
				if(arr[99][i] == 2) x = i;
			}
			boolean isRight = false;
			boolean isLeft = false;
			int index = 98;
			for(int i = index; i >= 0; i--) {
				int left = x - 1;
				int right = x + 1;
				
				if(left >= 0) {
					if(arr[i][left] == 1) {
						x = left; index = i; isLeft = true;
						break;
					}
				}
				
				if(right < 100) {
					if(arr[i][right] == 1) {
						x = right; index = i; isRight = true;
						break;
					}
				}
			}
			for(int i = index; i >= 0; i--) {
				int left = x - 1;
				int right = x + 1;
				if(left >= 0) {
					if(arr[i][left] == 1 && isLeft == true) {
						x = left;
						i++;
						isRight = false;
						isLeft = true;
						continue;
					}
				}
				if(right < 100) {
					if(arr[i][right] == 1 && isRight == true) {
						x = right;
						i++;
						isRight = true;
						isLeft = false;
						continue;
					}
				}
				isRight = true;
				isLeft = true;
			}
			System.out.println("#"+ T + " " + x);
		}
	}
}
