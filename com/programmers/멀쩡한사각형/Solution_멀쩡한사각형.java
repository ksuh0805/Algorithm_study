package com.programmers.멀쩡한사각형;

public class Solution_멀쩡한사각형 {
	public static long solution(int w, int h) {
        long answer = (long)w * (long)h;
        int gcd = gcd(w, h);
        // long cut = (long)((h / gcd) - 1) * 2 * gcd;
        long cut = (((long)w / gcd) + ((long)h / gcd) - 1) * gcd;
        return answer - cut;
    }
    public static int gcd(int a, int b){
        int n;
        if(b > a) {
            int t = b;
            b = a;
            a = t;
        }
        while(b != 0){
            n = a % b;
            a = b;
            b = n;
        }
        return a;
    }
    public static void main(String[] args) {
		System.out.println(solution(8, 12));
	}
}
