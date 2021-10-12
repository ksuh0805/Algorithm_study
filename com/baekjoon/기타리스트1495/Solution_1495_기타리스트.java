package com.baekjoon.기타리스트1495;

import java.util.Scanner;

public class Solution_1495_기타리스트 {
	public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int S = sc.nextInt();
        int M = sc.nextInt();
        
        int[] V = new int[N];
        for(int i = 0; i < N; i++){
            V[i] = sc.nextInt();
        }
        int[][] results = new int[N + 1][M + 1];
        
        results[0][S] = 1;
        for(int i = 0; i < N; i++){
            int v = V[i];
            for(int j = 0; j <= M; j++){
                if(results[i][j] == 1){
                    if(j + v <= M) results[i + 1][j + v] = 1;
                    if(j - v >= 0) results[i + 1][j - v] = 1;
                }
            }
        }
        for(int i = M; i >= 0; i--){
            if(results[N][i] == 1){
                System.out.println(i);
                System.exit(0);
            }
        }
        System.out.println(-1);
    }
}
