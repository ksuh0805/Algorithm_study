package com.swexpert.규영이와인영이의카드게임6808;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution_6808 {
	static int[] i_cards = new int[9];
	static ArrayList<Integer> kyu = new ArrayList<>();
	static ArrayList<Integer> in = new ArrayList<>();
	static int ksum, isum, wc, lc;
	static boolean[] visited = new boolean[9];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			i_cards = new int[9];
			kyu = new ArrayList<>();
			in = new ArrayList<>();
			visited = new boolean[9];
			
			int[] input = new int[19];
			for(int i = 0; i < 9; i++) {
				int tmp = sc.nextInt();
				input[tmp] = 1;
			}
			for(int i = 1; i < 19; i++) {
				if(input[i] == 1)
					kyu.add(i);
				else
					in.add(i);
			}
			wc = 0;
			lc = 0;
			perm(0);
			
			System.out.println("#" + tc + " " + wc + " " + lc);
		}
	}
	public static void perm(int depth) {
		if(depth == 9) {
			ksum = 0;
			isum = 0;
			for(int i = 0; i < 9; i++) {
				int sum = kyu.get(i) + i_cards[i];
				if(kyu.get(i) > i_cards[i]) ksum += sum;
				else isum += sum;
			}
			if(ksum > isum) wc++;
			else lc++;
		}
		for(int i = 0; i < 9; i++) {
			if(visited[i] == false) {
				visited[i] = true;
				i_cards[depth] = in.get(i);
				perm(depth + 1);
				visited[i] = false;
			}
		}
	}
}
