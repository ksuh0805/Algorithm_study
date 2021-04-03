package com.swexpert.상호의배틀필드1873;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution_1873 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("/Users/suhyun/SSAFY/workspace/Algorithm/src/com/swexpert/상호의배틀필드1873/input.txt")); // 파일 입출력
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int height = sc.nextInt();
			int width = sc.nextInt();
			char[][] map = new char[height][width];
			for(int i = 0; i < height; i++) {
				map[i] = sc.next().toCharArray();
			}
			int input = sc.nextInt();
			char[] inputs = new char[input];
			int x = 0;
			int y = 0;
			for(int i = 0; i < height; i++) {
				for(int j = 0; j < width; j++) {
					if(map[i][j] == '>' || map[i][j] == '<' || map[i][j] == '^' || map[i][j] == 'v') {
						x = i;
						y = j;
					}
				}
			}
			for(int i = 0; i < input; i++) {
				char now = inputs[i];
				if(now == 'U') {
					int k = x;
					k--;
					if(k < 0) continue;
					if(map[k][y] == '.') {
						map[k + 1][y] = '.';
						x--;
						continue;
					}
				}else if(now == 'D') {
					int k = x;
					k++;
					if(k >= height) continue;
					if(map[k][y] == '.') {
						map[k - 1][y] = '.';
						x++;
						continue;
					}
				}else if(now == 'L') {
					int k = y;
					y--;
					if(k < 0) continue;
					if(map[k][y] == '.') {
						map[x][y + 1] = '.';
						y--;
						continue;
					}
				}else if(now == 'R') {
					int k = y;
					k--;
					if(k >= width) continue;
					if(map[k][y] == '.') {
						map[x][y - 1] = '.';
						y++;
						continue;
					}
				}else if(now == 'S') {
					char tank = map[x][y];
					if(tank == '^') {
						int k = x;
						int l = y;
						while(true) {
							if(k - 1 < 0) break;
							char next  = map[k - 1][l];
							if(next == '.' || next == '*' || next == '-') {
								k--;								
								if(next == '*') map[k][l] = '.';
							}else break;
						}
					}else if(tank == 'v') {
						int k = x;
						int l = y;
						while(true) {
							if(k + 1 >= width) break;
							char next  = map[k + 1][l];
							if(next == '.' || next == '*' || next == '-') {
								k++;								
								if(next == '*') map[k][l] = '.';
							}else break;
						}
					}else if(tank == '<') {
						int k = x;
						int l = y;
						while(true) {
							if(l - 1 < 0) break;
							char next  = map[k][l - 1];
							if(next == '.' || next == '*' || next == '-') {
								l--;								
								if(next == '*') map[k][l] = '.';
							}else break;
						}
					}else if(tank == '>') {
						int k = x;
						int l = y;
						while(true) {
							if(l + 1 >= width) break;
							char next  = map[k][l + 1];
							if(next == '.' || next == '*' || next == '-') {
								l++;								
								if(next == '*') map[k][l] = '.';
							}else break;
						}
					}
				}
			} // inputs 탐색 끝
			System.out.print("#" + tc + " ");
			for(int u = 0; u < height; u++) {
				for(int v = 0; v < width; v++) {
					System.out.print(map[u][v]);
				}
				System.out.println();
			}
		}
	}
}
