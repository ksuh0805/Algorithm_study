package com.swexpert.암호문1_1228;

import java.util.LinkedList;
import java.util.Scanner;

public class Solution_1228 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int T = 1; T <= 10; T++) {
			int n = sc.nextInt();
			LinkedList<Integer> origin = new LinkedList<>();
			for(int i = 0; i < n; i++) {
				origin.add(sc.nextInt());
			}
			int count = sc.nextInt();
			for(int i = 0; i < count; i++) {
				sc.next();
				int x = sc.nextInt();
				int y = sc.nextInt();
				for(int j = 0; j < y; j++) {
					origin.add(x++, sc.nextInt());
				}
			}
			System.out.print("#" + T + " ");
			for(int i = 0; i < 10; i++) {
				System.out.print(origin.get(i) + " ");
			}System.out.println();
		}
	}
}
