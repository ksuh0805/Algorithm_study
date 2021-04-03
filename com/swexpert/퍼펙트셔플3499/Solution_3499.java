package com.swexpert.퍼펙트셔플3499;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution_3499 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int num = sc.nextInt();
			String[] cards = new String[num];
			ArrayList<String> card1 = new ArrayList<>();
			ArrayList<String> card2 = new ArrayList<>();
			ArrayList<String> card = new ArrayList<>();

			for(int i = 0; i < num; i++) {
				cards[i] = sc.next();
			}

			for(int i = 0; i < num; i++) {
				if(num % 2 != 0 && i == (num / 2)) card1.add(cards[i]);
				else if(i < num / 2) card1.add(cards[i]);
				else card2.add(cards[i]);
			}
			for(int i = 0; i < num / 2; i++) {
				card.add(card1.get(i));
				card.add(card2.get(i));
			}
			if(num % 2 != 0) card.add(card1.get(num / 2));
			
			System.out.print("#"+ tc + " ");
			for(int i = 0; i < num; i++) {
				System.out.print(card.get(i) + " ");
			}
		}
	}
}
