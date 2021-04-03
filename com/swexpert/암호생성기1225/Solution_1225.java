package com.swexpert.암호생성기1225;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_1225 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue<Integer> numbers = new LinkedList<>();
		int T = 0;
		while(sc.hasNext()) {
			T = sc.nextInt();
			for(int i = 0; i < 8; i++) {
				numbers.offer(sc.nextInt());
			}
			int first = -1;
			while(first != 0) {
				for(int i = 1; i <= 5; i++) {
					int num = numbers.poll() - i;
					if(num <= 0) {
						num = 0;
						first = 0;
						numbers.offer(num);
						break;
					}
					numbers.offer(num);
				}
			}
			System.out.print("#" + T + " ");
			for(int i = 0; i < 8; i++) {
				System.out.print(numbers.poll() + " ");
			}
			System.out.println();
			numbers.clear();
		}
	}
}
