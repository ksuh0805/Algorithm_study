package com.programmers.자물쇠와열쇠;

public class Solution_자물쇠와열쇠 {
	static int L, K;
	static int[][] tempL, tempK, extended, KEY;
	public static boolean solution(int[][] key, int[][] lock) {
        L = lock.length;
        K = key.length;
        KEY = key;
        extended = new int[L + 2 * (K - 1)][L + 2 * (K - 1)];
        for(int i = K - 1; i < K - 1 + L; i++) {
        	for(int j = K - 1; j < K - 1 + L; j++) {
        		extended[i][j] = lock[i - (K - 1)][j - (K - 1)];
        	}
        }
        for(int i = 0; i < K + L - 1; i++) {
        	for(int j = 0; j < K + L - 1; j++) {
        		if(roll(i , j)) return true;
        	}
        }
        return false;
    }
	private static boolean roll(int x, int y) {
		for(int d = 0; d < 4; d++) {
			unlock(d, x, y);
			if(check()) return true;
		}
		return false;
	}
	private static boolean check() {
		for(int i = K - 1; i < K - 1 + L; i++) {
			for(int j = K - 1; j < K - 1 + L; j++) {
				if(tempL[i][j] != 1) return false;
			}
		}
		return true;
	}
	private static void unlock(int d, int x, int y) {
		tempL = new int[L + 2 * (K - 1)][L + 2 * (K - 1)];
		for(int i = K - 1; i < K - 1 + L; i++) {
        	for(int j = K - 1; j < K - 1 + L; j++) {
				tempL[i][j] = extended[i][j];
			}
		}
		for(int i = 0; i < K; i++) {
			for(int j = 0; j < K; j++){
				if(d == 0) {
					tempL[i + x][j + y] += KEY[i][j];
				}else if(d == 1) {
					tempL[i + x][j + y] += KEY[K - j - 1][i];					
				}else if(d == 2) {
					tempL[i + x][j + y] += KEY[K - i - 1][K - j - 1];					
				}else if(d == 3){
					tempL[i + x][j + y] += KEY[j][K - i - 1];				
				}			
			}
		}
	}
	public static void main(String[] args) {
		System.out.println(solution(new int[][] {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}}, new int[][] {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}}));
	}
}
