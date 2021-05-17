package com.programmers.소수만들기;

import java.util.ArrayList;

public class Solution_소수만들기 {
	static ArrayList<Integer> Primes;
    static int[] Ns, result;
    static int answer;
    public static int solution(int[] nums) {
        getPrimes();
        Ns = nums;
        result = new int[3];
        answer = 0;
        combination(0, 0);
        return answer;
    }
    public static void combination(int depth, int start){
        if(depth == 3){
            int sum = 0;
            for(int i = 0; i < 3; i++){
                sum += result[i];
            }
            if(Primes.contains(sum)) answer++;
            return;
        }
        for(int i = start; i < Ns.length; i++){
            result[depth] = Ns[i];
            combination(depth + 1, i + 1);
        }
    }
    public static void getPrimes(){
        Primes = new ArrayList<>();
        boolean[] check = new boolean[3000];
        for(int i = 2; i < 3000; i++){
            if(check[i]) continue;
            Primes.add(i);
            for(int j = i + i; j < 3000; j += i){
                check[j] = true;
            }
        }
    }
    public static void main(String[] args) {
		System.out.println(solution(new int[] {1,2,3,4}));
		System.out.println(solution(new int[] {1,2,7,6,4}));
	}
}
