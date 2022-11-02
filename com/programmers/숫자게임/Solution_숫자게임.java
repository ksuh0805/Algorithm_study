package com.programmers.숫자게임;

import java.util.Arrays;

public class Solution_숫자게임 {
	public static int solution(int[] A, int[] B) {
        int N = A.length;
        Arrays.sort(A);
        Arrays.sort(B);
        int idxA = 0;
        int idxB = 0;
        int cnt = 0;
        while(idxA < N && idxB < N) {
        	if(A[idxA] < B[idxB]) {
        		cnt++;
        		idxA++;
        	}
        	idxB++;
        }
        return cnt;
    }
	public static void main(String[] args) {
		System.out.println(solution(new int[] {5,1,3,7}, new int[] {2,2,6,8}));
		System.out.println(solution(new int[] {2,2,2,2}, new int[] {1,1,1,1}));
	}
}
