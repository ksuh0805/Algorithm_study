package com.baekjoon.덩치_7568;

import java.util.Scanner;

public class Solution_7568_덩치 {
	static int N;
	static class Person implements Comparable<Person>{
		int weight;
		int height;
		
		public Person(int w, int h){
			this.weight = w;
			this.height = h;
		}
		
		@Override
		public int compareTo(Person o) {
			if(this.weight < o.weight && this.height < o.height) return 1;
			return 0;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		Person[] ps = new Person[N];
		for(int i = 0; i < N; i++) {
			int w = sc.nextInt();
			int h = sc.nextInt();
			ps[i] = new Person(w, h);
		}
		for(int i = 0; i < N; i++) {
			Person p = ps[i];
			int rank = 1;
			for(int j = 0; j < N; j++) {
				if(i == j) continue;
				if(p.compareTo(ps[j]) == 1) rank++;
			}
			System.out.print(rank + " ");
		}
	}
}
