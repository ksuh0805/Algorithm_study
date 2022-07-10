package com.programmers.메뉴리뉴얼;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution_메뉴리뉴얼 {
	static char[] chars, menu;
	static Map<String, Integer> map;
	static Map<Integer, Integer> res;
	static int N;
	public static String[] solution(String[] orders, int[] course) {
		map = new HashMap<>();
		res = new HashMap<>();
		for(int i = 0; i < orders.length; i++) {
			String original = orders[i];
	        chars = original.toCharArray();
	        Arrays.sort(chars);
	        N = chars.length;
	        for(int j = 0; j < course.length; j++) {
	        	if(N < course[j]) break;
	        	menu = new char[course[j]];
	        	combination(0, 0, course[j]);
	        }
		}
		ArrayList<String> list = new ArrayList<>();
		for(Integer i : res.keySet()){ // 길이
			int x = res.get(i); // 최대 횟수
			for(String s : map.keySet()){ // 메뉴
				if(s.length() == i && map.get(s) == x) {
					list.add(s);
				}
			}
		}
		String[] ans = new String[list.size()];
		for(int i = 0; i < list.size(); i++) {
			ans[i] = list.get(i);
		}
		Arrays.sort(ans);
		return ans;
	}
	private static void combination(int depth, int start, int size) {
		if(depth == size) {
			String m = String.valueOf(menu);
			map.put(m, map.getOrDefault(m, 0) + 1);
			int n = map.get(m);
			int k = res.getOrDefault(size, 1);
			if(n > k) res.put(size, n);
			return;
		}
		for(int i = start; i < N; i++) {
			menu[depth] = chars[i];
			combination(depth + 1, i + 1, size);
		}
	}
	public static void main(String[] args) {
		String[] result = solution(new String[] {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"}, new int[] {2, 3, 4});
		for(int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
		System.out.println();
		result = solution(new String[] {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"}, new int[] {2, 3, 5});
		for(int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
		System.out.println();
		result = solution(new String[] {"XYZ", "XWY", "WXA"}, new int[] {2, 3, 4});
		for(int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
	}
}
