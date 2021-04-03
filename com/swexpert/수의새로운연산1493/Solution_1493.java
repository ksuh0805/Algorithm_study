package com.swexpert.수의새로운연산1493;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1493 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			int[] ploc = location(p);
			int[] qloc = location(q);
			int x = ploc[0] + qloc[0];
			int y = ploc[1] + qloc[1];
			System.out.println("#" + tc + " " + num(x, y));
		}
	}
	public static int[] location(int n) {
		int count = 1;
		int num = 1;
		while(true) {
			if(n <= count) break;
			count += ++num;
		}
		int a = count - n;
		int x = num - a;
		int y = num - (num - 1 - a);
		return new int[] {x,y};
	}
	public static int num(int x, int y) {
		int num = x + y - 1;
		int sum = 0;
		while(num > 0) {
			sum += num--;
		}
		System.out.println(sum);
		return sum - (x + y - 1 - x);
		
	}
	
}
