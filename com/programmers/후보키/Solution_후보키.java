package com.programmers.후보키;

import java.util.ArrayList;
import java.util.HashSet;

public class Solution_후보키 {
	static int[] arr;
	static ArrayList<String> res;
	static int N, M, L;
	static String[][] rel;
	static int answer;
	public static int solution(String[][] relation) {
        N = relation[0].length;
        L = relation.length;
        rel = relation;
        answer = 0;
        res = new ArrayList<>();
        for(int i = 1; i <= N; i++) {
        	M = i;
        	arr = new int[M];
        	combination(0, 0);
        }
        
        return answer;
    }
	private static void combination(int depth, int start) {
		if(depth == M) {
			String s = "";
			for(int j = 0; j < M; j++) {
				s += Integer.toString(arr[j]);
			}
			for(int i = 0; i < res.size(); i++) {
				boolean flag = false;
				String r = res.get(i);
				for(int j = 0; j < r.length(); j++) {
					if(!(s.contains(Character.toString(r.charAt(j))))) flag = true;
				}
				if(!flag) return;
			}
			candidate(s);
			return;
		}
		for(int i = start; i < N; i++) {
			arr[depth] = i;
			combination(depth + 1, i + 1);
		}
	}
	private static void candidate(String ss) {
		HashSet<String> set = new HashSet<>();
		for(int i = 0; i < L; i++) {
			String[] row = rel[i];
			String s = "";
			for(int j = 0; j < M; j++) {
				s += row[arr[j]];
			}
			set.add(s);
		}
		if(set.size() == L) {
			res.add(ss);
			answer++;
		}
	}
	public static void main(String[] args) {
		System.out.println(solution(new String[][] {{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}}));
		System.out.println(solution(new String[][] { {"a","1","aaa","c","ng"},
			{"a","1","bbb","e","g"},
			{"c","1","aaa","d","ng"},
			{"d","2","bbb","d","ng"}}));
	}
}
