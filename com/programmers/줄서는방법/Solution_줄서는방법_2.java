package com.programmers.줄서는방법;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution_줄서는방법_2 {
	public static int[] solution(int n, long k) {
        int[] answer = new int[n];
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 1; i <= n; i++) {
        	list.add(i);
        }
        long idx = 0;
        k--;
        for(int i = 0; i < n; i++) {
        	long a = N(i, n);
        	idx = k / a;
        	answer[i] = list.get((int) idx);
        	list.remove((int) idx);
        	k = k % a;
        }
        return answer;
    }
	private static long N(int i, int n) {
		long k = 1;
		n -= (i + 1);
		while(n > 1) {
			k *= n--;
		}
		return k;
	}
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(3, 5)));
	}
}
