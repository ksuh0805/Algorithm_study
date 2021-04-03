package com.swexpert.쇠막대기자르기5432;
import java.util.Scanner;
import java.util.Stack;

public class SW_D4_5432_쇠막대기자르기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {

			char[] data = sc.next().toCharArray();
			int ans = 0, cnt = 0;
			Stack<Character> s = new Stack<>();
			for (char c : data) {
				if (c == '(') {
					cnt = 0;
					s.push(c);
					continue;
				} 
				// )일 경우 스택에서 (를 하나 제거해서 짝을 맞춘다.
				s.pop();
				
				// ) 가 나올 경우 cnt의 개수를 1 증가시킨다.
				// 만약, 기존 cnt의 숫자가 0일 경우는 "()" 이 경우이므로 레이저의 경우이다. 
				// 기존 stack에 들어있는 막대의 수를 카운트 한다. 
				if (cnt++ == 0) {
					ans += s.size();
				} else {  // 이 경우 레이저가 아니고 막대의 끝이다
					ans += 1;
				}
			}
			System.out.println("#" + t + " " + ans);
		}
	}
}