package com.leetcode.LongestSubstringWithoutRepeatingCharacters;

public class Solution_LongestSubstringWithoutRepeatingCharacters {
	public static int lengthOfLongestSubstring(String s) {
		int max = 0;
		String ss = "";
		int start = 0;
		for(int i = 0; i < s.length(); i++) {
			String c = Character.toString(s.charAt(i));
			if(ss.contains(c)) {
				max = Math.max(max, ss.length());
				ss = "";
				start++;
				i = start - 1;
				continue;
			}
			ss += c;
		}
		max = Math.max(max, ss.length());
        return max;
    }
	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("abcabcbb"));
		System.out.println(lengthOfLongestSubstring("bbbbb"));
		System.out.println(lengthOfLongestSubstring("pwwkew"));
		System.out.println(lengthOfLongestSubstring("aab"));
		System.out.println(lengthOfLongestSubstring("dvdf"));
	}
}
