package com.leetcode.PalindromeNumber;

public class Solution_PalindromeNumber {
	public static boolean isPalindrome(int x) {
        if(x < 0) return false;
        String s = String.valueOf(x);
        int start = 0;
        int end = s.length() - 1;
        while(true) {
        	if(start >= s.length() || end < 0) return true;
        	if(start == end) return true;
        	if(s.charAt(start) == s.charAt(end)) {
        		start++;
        		end--;
        	}else return false;
        }
    }
	public static void main(String[] args) {
		System.out.println(isPalindrome(121));
		System.out.println(isPalindrome(-121));
		System.out.println(isPalindrome(10));
	}
}
