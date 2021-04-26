package com.programmers.소수찾기;

import java.util.HashSet;
import java.util.Set;

public class Solution_소수찾기 {
	static char[] num, temp;
    static int len;
    static boolean[] visited, primes, isSelected;
    static Set<Integer> set;
    public static int solution(String numbers) {
        len = numbers.length();
        num = numbers.toCharArray();
        isSelected = new boolean[len];
        set = new HashSet<>();
        prime();
        subset(0);
        return set.size();
    }
    public static void subset(int depth){
        if(depth == len){
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < len; i++){
                if(isSelected[i]){
                    sb.append(num[i]);
                }
            }
            int l = sb.length();
            if(l == 0) return;
            visited = new boolean[l];
            temp = new char[l];
            permutation(0, sb.toString().toCharArray(), l);
            return;
        }
        isSelected[depth] = true;
        subset(depth + 1);
        isSelected[depth] = false;
        subset(depth + 1);
    }
    public static void prime(){
        primes = new boolean[10000000];
        primes[0] = true;
        primes[1] = true;
        for(int i = 2; i < 10000000; i++){
            if(!primes[i]){
                for(int j = i + i; j < 10000000; j += i){
                    primes[j] = true;
                }
            }
        }
    }
    public static void permutation(int depth, char[] c, int l){
        if(depth == l){
            int n = Integer.parseInt(String.valueOf(temp));
            if(!primes[n]) {
                set.add(n);
            }
            return;
        }
        for(int i = 0; i < l; i++){
            if(!visited[i]){
                visited[i] = true;
                temp[depth] = c[i];
                permutation(depth + 1, c, l);
                visited[i] = false;
            }
        }
    }
	public static void main(String[] args) {
		System.out.println(solution("17"));
		System.out.println(solution("011"));
	}
}
