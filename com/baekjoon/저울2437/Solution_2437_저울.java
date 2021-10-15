package com.baekjoon.저울2437;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_2437_저울 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	    int N = sc.nextInt();
	    int[] weights = new int[N];
	    
	    for(int i = 0 ; i < N; i++){
	        weights[i] = sc.nextInt();
	    }
	    Arrays.sort(weights);
	    int max = 0;
	    for(int i = 0; i < N; i++){
	        if(max + 1 >= weights[i]) max += weights[i];
	        else break;
	    }
	    System.out.println(max + 1);
	}
}
