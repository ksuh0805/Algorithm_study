package com.leetcode.RomanToInteger;

public class Solution_RomanToInteger {
	public static int romanToInt(String s) {
        int res = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(i < s.length() - 1) {
            	if(c == 'I') {
            		if(s.charAt(i + 1) == 'V') {
            			i++;
            			res += 4;
            			continue;
            		}else if(s.charAt(i + 1) == 'X') {
            			i++;
            			res += 9;
            			continue;
            		}
            	}else if(c == 'X') {
            		if(s.charAt(i + 1) == 'L') {
            			i++;
            			res += 40;
            			continue;
            		}else if(s.charAt(i + 1) == 'C') {
            			i++;
            			res += 90;
            			continue;
            		}
            	}else if(c == 'C') {
            		if(s.charAt(i + 1) == 'D') {
            			i++;
            			res += 400;
            			continue;
            		}else if(s.charAt(i + 1) == 'M') {
            			i++;
            			res += 900;
            			continue;
            		}
            	}
            }
            int num = 0;
            switch(c){
                case 'I' : num = 1;
                     break;
                case 'V' : num = 5;
                    break;
                case 'X' : num = 10;
                    break;
                case 'L' : num = 50;
                    break;
                case 'C' : num = 100;
                    break;
                case 'D' : num = 500;
                    break;
                case 'M' : num = 1000;
                    break;
            }
            res += num;
        }
        return res;
    }
	public static void main(String[] args) {
		System.out.println(romanToInt("III"));
		System.out.println(romanToInt("LVIII"));
		System.out.println(romanToInt("MCMXCIV"));
	}
}
