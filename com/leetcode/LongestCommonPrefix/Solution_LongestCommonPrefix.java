package com.leetcode.LongestCommonPrefix;

import java.util.Arrays;

public class Solution_LongestCommonPrefix {
	public static String longestCommonPrefix(String[] strs) {
		String prefix = "";
        Arrays.sort(strs, (o1, o2) -> (o1.length() - o2.length()));
        prefix = strs[0];
        outer:
        for(int i = 1; i < strs.length; i++) {
        	String next = strs[i];
        	while(true) {
        		if(next.startsWith(prefix)) continue outer;
        		else {
        			if(prefix.length() == 1) {
        				prefix = "";
        				break outer;
        			}
        			prefix = prefix.substring(0, prefix.length() - 1);
        		}
        	}
        }
		return prefix;
    }
	public static void main(String[] args) {
		System.out.println(longestCommonPrefix(new String[] {"flower","flow","flight"}));
		System.out.println(longestCommonPrefix(new String[] {"dog","racecar","car"}));
	}
}
