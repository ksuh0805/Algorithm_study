package com.swexpert.방향전환8382;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_8382_방향전환 {
	static int[] dir = {-1, 1};
	static int[] first = new int[2];
	static int[] last = new int[2];
	static int min;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			first[0] = Integer.parseInt(st.nextToken());
			first[1] = Integer.parseInt(st.nextToken());
			last[0] = Integer.parseInt(st.nextToken());
			last[1] = Integer.parseInt(st.nextToken());
			min = Integer.MAX_VALUE;
			move(true);
			move(false);
			
			System.out.println("#" + tc + " " + min);
		}
	}
	private static void move(boolean garo) {
		boolean flag = garo;
		int count = 0;
		int x = first[0];
		int y = first[1];
		while(true) {
			if(x == last[0] && y == last[1]) {
				min = Math.min(min, count);
				return;
			}
			if(flag) {
				if(x >= last[0]) x--;
				else x++;
				count++;
				flag = false;
			}else {
				if(y >= last[1]) y--;
				else y++;
				flag = true;
				count++;
			}
		}
	}
}
