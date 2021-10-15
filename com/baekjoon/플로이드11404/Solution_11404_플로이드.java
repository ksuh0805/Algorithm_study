package com.baekjoon.플로이드11404;

import java.util.Scanner;

public class Solution_11404_플로이드 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] cities = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++) {
                if(i == j) continue;
                cities[i][j] = 10000001;
            }
        }
        for(int i = 0; i < m; i++){
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;
            int c = sc.nextInt();
            if(cities[a][b] < c) continue;
            cities[a][b] = c;
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                if (i == k)
                    continue; // 출발지와 경유지가 같다면 다음 출발지
                for (int j = 0; j < n; j++) {
                    if (i == j || k == j)
                        continue; // 경유지와 목적지가 같거나 출발지가 곧 목적지라면 패스
                    if (cities[i][j] > cities[i][k] + cities[k][j]) {
                        cities[i][j] = cities[i][k] + cities[k][j];
                    }
                }
            }
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(cities[i][j] == 10000001) cities[i][j] = 0;
                System.out.print(cities[i][j] + " ");
            }System.out.println();
        }
    }
}
