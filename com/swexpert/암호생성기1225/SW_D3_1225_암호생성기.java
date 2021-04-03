package com.swexpert.암호생성기1225;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW_D3_1225_암호생성기 {
	public static void main(String[] args) throws IOException {
		InputStream in = System.in;
		InputStreamReader isr = new InputStreamReader(in);
		BufferedReader br = new BufferedReader(isr);
		while(true) {
			String line = br.readLine();
			System.out.println(line);
			
			String[] tokens = line.split(" ");
			for(String s : tokens) System.out.println(s);
			
			
//			StringTokenizer st = new StringTokenizer(line, " ");
//			System.out.println(st.countTokens());
//			int count = st.countTokens();
//			for(int i = 0; i < count; i++) {
//				System.out.println(st.nextToken());
//			}
		}
	}
	public static void main2(String[] args) throws Exception {
		int cycle;
		int tmp;
		int[] number = new int[8];
		Queue<Integer> queue = new LinkedList<>();
	    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] tokens;
		for (int t = 1; t <= 10; t++) {
			reader.readLine();
			tokens = reader.readLine().split(" ");
			// 
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < 8; i++) {
				number[i] = Integer.parseInt(tokens[i]);
				min = Math.min(min, number[i]);
			}
//			System.out.println("min -> " + min);
			
			// 1 + 2 + 3 + 4 + 5 : 15
			// 입력된 값의 최소값을 찾아서 특정 사이클이 수행될때 같아지는 공통의 수중에서 최대값을 구한다.
			int v = min / 15 * 15;
			if (min == v) v -= 15;
//			System.out.println(v);
			
			queue.clear();
			
			// Queue에 값 대입하기
			for (int i = 0; i < 8; i++) {
				queue.add(number[i] - v);
			}
//			System.out.println(queue);
			
			// 사이클 돌리기
			cycle = 1;
			while (true) {
				tmp = queue.poll() - cycle;

				cycle++;
				if (cycle == 6)
					cycle = 1;
				
				if (tmp <= 0) {
					queue.offer(0);
					break;
				} 
				queue.offer(tmp);
			}

			System.out.print("#" + t + " ");
			for (int j = 0; j < 8; j++) {
				System.out.print(queue.poll() + " ");
			}
			System.out.println();
		}
	}

}