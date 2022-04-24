package com.programmers.단체사진찍기;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution_단체사진찍기 {
	static ArrayList<String> friends = new ArrayList<String>(Arrays.asList("A", "C", "F", "J", "M", "N", "R", "T"));
	static ArrayList<String> lines = new ArrayList<String>(Arrays.asList("A", "C", "F", "J", "M", "N", "R", "T"));
	static boolean[] visited = new boolean[8];
	static String[] rules;
	static int answer, N;
	public static int solution(int n, String[] data) {
		answer = 0;
        rules = data;
        N = n;
        permutation(0);
        return answer;
    }
	private static void permutation(int depth) {
		if(depth == 8) {
			checkRules();
			return;
		}
		for(int i = 0; i < 8; i++) {
			if(!visited[i]) {
				visited[i] = true;
				lines.set(depth, friends.get(i));
				permutation(depth + 1);
				visited[i] = false;
			}
		}
	}
	private static void checkRules() {
		for(int i = 0; i < N; i++) {
			String rule = rules[i];
			int a = lines.indexOf(Character.toString(rule.charAt(0)));
			int b = lines.indexOf(Character.toString(rule.charAt(2)));
			int d = Math.abs(a - b) - 1;
			String c = Character.toString(rule.charAt(3));
			int rd = rule.charAt(4) - '0';
			if(c.equals("=")) {
				if(d != rd) return;
			}else if(c.equals(">")) {
				if(d <= rd) return;
			}else {
				if(d >= rd) return;
			}
		}
		answer++;
	}
	public static void main(String[] args) {
		System.out.println(solution(2, new String[] {"N~F=0", "R~T>2"}));
		System.out.println(solution(2, new String[] {"M~C<2", "C~M>1"}));
	}
}
