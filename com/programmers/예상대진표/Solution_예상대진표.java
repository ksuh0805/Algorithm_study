package com.programmers.예상대진표;

public class Solution_예상대진표 {
	public static int solution(int n, int a, int b){
        if(a > b) {
            int temp = a;
            a = b;
            b = temp;
        }
        int answer = 1;
        while(true) {
        	if(a + 1 == b && a % 2 == 1) return answer;
        	a = next(a);
        	b = next(b);
        	answer++;
        }
    }
	
	private static int next(int n) {
		if(n % 2 == 0) {
			return n / 2;
		}
		return (n + 1) / 2;
	}

	public static void main(String[] args) {
		System.out.println(solution(8, 4, 7));
	}
}
