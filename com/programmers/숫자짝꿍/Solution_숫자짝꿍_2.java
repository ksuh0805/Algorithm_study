package com.programmers.숫자짝꿍;

public class Solution_숫자짝꿍_2 {
	public static String solution(String X, String Y) {
        int[] xlist = new int[10];
        for(int i = 0; i < X.length(); i++) {
        	xlist[X.charAt(i) - '0']++;
        }
        int[] ylist = new int[10];
        for(int i = 0; i < Y.length(); i++) {
        	ylist[Y.charAt(i) - '0']++;
        }
        int[] list = new int[10];
        for(int i = 0; i < 10; i++) {
        	if(xlist[i] >= ylist[i]) list[i] = ylist[i];
        	else list[i] = xlist[i];
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 9; i >= 0; i--){
        	int n = list[i];
        	if(n == 0) continue;
        	for(int j = 0; j < n; j++) {
        		sb.append(i);
        	}
        }
        String s = sb.toString();
        if(s.length() == 0) return "-1";
        else if(s.charAt(0) == '0') return "0";
        return s;
    }
	public static void main(String[] args) {
		System.out.println(solution("100", "2345"));
		System.out.println(solution("100", "203045"));
		System.out.println(solution("100", "123450"));
		System.out.println(solution("12321", "42531"));
		System.out.println(solution("5525", "1255"));
	}
}
