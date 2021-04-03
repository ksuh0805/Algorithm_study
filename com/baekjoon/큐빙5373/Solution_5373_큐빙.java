package com.baekjoon.큐빙5373;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_5373_큐빙 {
	static char[][] u,d,l,r,f,b;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		u = new char[3][3];
		d = new char[3][3];
		l = new char[3][3];
		r = new char[3][3];
		f = new char[3][3];
		b = new char[3][3];
		for(int tc = 0; tc < T; tc++) {
			int n = Integer.parseInt(br.readLine());
			for(int i = 0; i < 3; i++) {
				Arrays.fill(u[i], 'w');
				Arrays.fill(d[i], 'y');
				Arrays.fill(l[i], 'g');
				Arrays.fill(r[i], 'b');
				Arrays.fill(f[i], 'r');
				Arrays.fill(b[i], 'o');
			}
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < n; i++) {
				String s = st.nextToken();
				char m = s.charAt(0);
				char dir = s.charAt(1);
				roll(m,dir);
			}
			
			for(int i = 0; i < 3; i++) {
				for(int j = 0; j < 3; j++) {
					System.out.print(u[i][j]);
				}System.out.println();
			}
		}
	}
	private static void roll(char m, char dir) {
		if(m == 'U') {
			char[] temp = l[0];
			if(dir == '+') {
				l[0] = f[0];
				f[0] = r[0];
				r[0] = b[0];
				b[0] = temp;
			}else {
				l[0] = b[0];
				b[0] = r[0];
				r[0] = f[0];
				f[0] = temp;
			}
		}else if(m == 'D') {
			char[] temp = l[2];
			if(dir == '+') {
				l[2] = b[2];
				b[2] = r[2];
				r[2] = f[2];
				f[2] = temp;
			}else {
				l[2] = f[2];
				f[2] = r[2];
				r[2] = b[2];
				b[2] = temp;
			}
			
		}else if(m == 'F') {
			char[] temp = new char[3];
			for(int i = 0; i < 3; i++) {
				temp[i] = l[i][2];
			}
			if(dir == '+') {
				u[2] = temp;
			}else {
				l[0] = b[0];
				b[0] = r[0];
				r[0] = f[0];
				f[0] = temp;
			}
		}else if(m == 'B') {
			char[] temp = l[0];
			if(dir == '+') {
				l[0] = f[0];
				f[0] = r[0];
				r[0] = b[0];
				b[0] = temp;
			}else {
				l[0] = b[0];
				b[0] = r[0];
				r[0] = f[0];
				f[0] = temp;
			}
		}else if(m == 'L') {
			char[] temp = l[0];
			if(dir == '+') {
				l[0] = f[0];
				f[0] = r[0];
				r[0] = b[0];
				b[0] = temp;
			}else {
				l[0] = b[0];
				b[0] = r[0];
				r[0] = f[0];
				f[0] = temp;
			}
		}else if(m == 'R') {
			char[] temp = l[0];
			if(dir == '+') {
				l[0] = f[0];
				f[0] = r[0];
				r[0] = b[0];
				b[0] = temp;
			}else {
				l[0] = b[0];
				b[0] = r[0];
				r[0] = f[0];
				f[0] = temp;
			}
		}
	}
}
