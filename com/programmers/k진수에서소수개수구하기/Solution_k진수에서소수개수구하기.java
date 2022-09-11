package com.programmers.k진수에서소수개수구하기;

public class Solution_k진수에서소수개수구하기 {
	public static int solution(int n, int k) {
        int answer = 0;
        
        String kn = Integer.toString(n, k);
        String[] kns = kn.split("0+");
        for(int i = 0; i < kns.length; i++) {
        	String s = kns[i];
        	//if(s.length() < 1) continue;
        	long nn = Long.parseLong(s);
        	if(isPrime(nn)) answer++;
        }
        return answer;
    }
	private static boolean isPrime(long n) {
		if(n == 1) return false;
		else if(n == 2) return true;
		long sqrt = (long) Math.sqrt(n);
		for(long i = 2; i <= sqrt; i++) {
			if(n % i == 0) return false;
		}
		return true;
    }
	public static void main(String[] args) {
		System.out.println(solution(437674, 3));
		System.out.println(solution(110011, 10));
	}
}
