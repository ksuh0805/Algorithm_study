package com.baekjoon.동물원12907;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution_12907_동물원 {
	static int rabbit, cat, N, cnt;
	static int[] animals;
	static ArrayList<Integer> rlist;
	static ArrayList<Integer> clist;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		animals = new int[N];
		rabbit = 0;
		cat = 0;
		cnt = 0;
		rlist = new ArrayList<>();
		clist = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			animals[i] = sc.nextInt();
			if(animals[i] > N) {
				System.out.println(0);
				System.exit(0);
			}
		}
		rabbit(0);
		cat(0);
		
		System.out.println(cnt);
	}
	private static void cat(int n) {
		int num = animals[n] + 1;
		for(int i = 0; i < clist.size(); i++) {
			if(clist.get(i) == num) return;
		}
		clist.add(num);
		boolean flag = false;
		if(cat < num) {
			num -= cat;
			cat += num;
			flag = true;
		}
		if(n == N - 1) {
			if(rabbit + cat == N) {
				cnt++;
			}
			if(flag) cat -= num;
			clist.remove(clist.size() - 1);
			return;
		}
		rabbit(n + 1);
		cat(n + 1);
		if(flag) cat -= num;
		clist.remove(clist.size() - 1);
	}
	private static void rabbit(int n) {
		int num = animals[n] + 1;
		for(int i = 0; i < rlist.size(); i++) {
			if(rlist.get(i) == num) return;
		}
		rlist.add(num);
		boolean flag = false;
		if(rabbit < num) {
			num -= rabbit;
			rabbit += num;
			flag = true;
		}
		if(n == N - 1) {
			if(rabbit + cat == N) {
				cnt++;
			}
			if(flag) rabbit -= num;
			rlist.remove(rlist.size() - 1);
			return;
		}
		rabbit(n + 1);
		cat(n + 1);
		if(flag) rabbit -= num;
		rlist.remove(rlist.size() - 1);
	}
}
