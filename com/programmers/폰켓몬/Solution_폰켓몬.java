package com.programmers.폰켓몬;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Solution_폰켓몬 {
	public static int solution(int[] nums) {
		Set<Integer> set = new HashSet<>();
		ArrayList<Integer> list = new ArrayList<>();
		int index = 0;
		int N = nums.length;
		while(list.size() < N / 2 && index < N) {
			int n = nums[index];
			if(!list.contains(n)) {
				list.add(n);
			}
			index++;
		}
		return list.size();
	}
	public static void main(String[] args) {
		System.out.println(solution(new int[] {3, 1, 2, 3}));
		System.out.println(solution(new int[] {3, 3, 3, 2, 2, 4}));
		System.out.println(solution(new int[] {3, 3, 3, 2, 2, 2}));
	}
}
