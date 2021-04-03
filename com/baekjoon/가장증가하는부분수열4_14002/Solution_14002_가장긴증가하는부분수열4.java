package com.baekjoon.가장증가하는부분수열4_14002;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution_14002_가장긴증가하는부분수열4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		ArrayList<ArrayList<Integer>> LIS = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		int maxidx = 0;
		for(int i = 0; i < N; i++) {
			ArrayList<Integer> list = new ArrayList<>();
			list.add(arr[i]);
			LIS.add(list);
			for(int j = 0; j < i; j++) {
				if(arr[j] < arr[i] && LIS.get(i).size() < LIS.get(j).size() + 1) {
					ArrayList<Integer> temp = (ArrayList<Integer>) LIS.get(j).clone();
					temp.add(arr[i]);
					LIS.set(i, temp);
				}
			}
			if(LIS.get(maxidx).size() < LIS.get(i).size()) {
				maxidx = i;
			}
		}
		System.out.println(LIS.get(maxidx).size());
		for(int i = 0; i < LIS.get(maxidx).size(); i++) {
			System.out.print(LIS.get(maxidx).get(i) + " ");
		}
	}
}
