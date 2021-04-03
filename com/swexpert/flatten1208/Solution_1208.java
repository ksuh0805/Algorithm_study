package com.swexpert.flatten1208;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_1208 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int answer = 0;
		for(int T = 1; T < 11; T++) {
			int count = sc.nextInt();
			int[] arr = new int[100];
			for(int i = 0; i < 100; i++) {
				arr[i] = sc.nextInt();
			}
			while(count > 0) {
				int max = arr[0];
				int min = arr[0];
				int max_index = 0;
				int min_index = 0;
				for(int i = 1; i < 100; i++) {
					if(max < arr[i]) {
						max = arr[i];
						max_index = i;
					}
					else if(min > arr[i]) {
						min = arr[i];
						min_index = i;
					}
				}
				arr[max_index] -= 1;
				arr[min_index] += 1;
				if(max - min == 2) break;
				count--;
			}
			Arrays.sort(arr);
			answer = arr[99] - arr[0];
			System.out.println("#"+T+" "+answer);
		}
	}
}
