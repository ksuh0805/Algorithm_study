package com.programmers.징검다리건너기;

public class Solution_징검다리건너기 {
	public static int solution(int[] stones, int k) {
        int answer = 0;
        int start = 1;
        int last = 200000000;
        
        while(start <= last) {
        	int mid = (start + last) / 2;
        	if(check(stones, mid, k)) {
        		start = mid + 1;
        		answer = Math.max(answer, mid);
        	}else {
        		last = mid - 1;
        	}
        }
        return answer;
    }
	private static boolean check(int[] stones, int n, int k) {
		int skip = 0;
		for(int stone : stones) {
			if(stone < n) skip++;
			else skip = 0;
			if(skip == k) return false;
		}
		return true;
	}
	public static void main(String[] args) {
		System.out.println(solution(new int[] {2, 4, 5, 3, 2, 1, 4, 2, 5, 1}, 3));
	}
}
