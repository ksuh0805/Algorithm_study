package com.swexpert.퍼펙트셔플3499;

import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SW_D3_3499_퍼펙트셔플 {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			Queue<String> q1 = new LinkedList<>();
			Queue<String> q2 = new LinkedList<>();
			int N = sc.nextInt();
			
            int half = N / 2;
            int remain = N % 2;
			
			for (int i = 0; i < half + remain; i++)
				q1.offer(sc.next());

			for (int i = 0; i < half; i++)
				q2.offer(sc.next());


			System.out.print("#" + tc);
			for (int i = 0; i < half; i++) {
				System.out.print(" " + q1.poll() + " " +q2.poll());
			}
			if (!q1.isEmpty()) {
				System.out.print(" " + q1.poll());				
			}
			System.out.println();
		}
	}
}