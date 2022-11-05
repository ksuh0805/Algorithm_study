package com.programmers.뉴스클러스터링;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Solution_뉴스클러스터링 {
	public static int solution(String str1, String str2) {
	        ArrayList<String> set1 = new ArrayList<>();
	        ArrayList<String> set2 = new ArrayList<>();
	        ArrayList<String> union = new ArrayList<>();
	        ArrayList<String> intersection = new ArrayList<>();
	        str1 = str1.toLowerCase();
	        str2 = str2.toLowerCase();
	        for(int i = 0; i < str1.length() - 1; i++){
	            char c1 = str1.charAt(i);
	            char c2 = str1.charAt(i + 1);
	            if(c1 >= 'a' && c1 <= 'z' &&
	                c2 >= 'a' && c2 <= 'z'){
	                set1.add(c1 + "" + c2);
	            }
	        }
	        for(int i = 0; i < str2.length() - 1; i++){
	            char c1 = str2.charAt(i);
	            char c2 = str2.charAt(i + 1);
	            if(c1 >= 'a' && c1 <= 'z' &&
	                c2 >= 'a' && c2 <= 'z'){
	                set2.add(c1 + "" + c2);
	            }
	        }
	        Collections.sort(set1);
	        Collections.sort(set2);
	        
	        for(String s : set1){
	            if(set2.remove(s)){
	                intersection.add(s);
	            }
	            union.add(s);
	        }
	        for(String s : set2){
	            union.add(s);
	        }
	        double answer = 0;
	        if(union.size() == 0) answer = 1;
	        else answer = (double)intersection.size() / union.size();
	        return (int)(answer * 65536);
	}

	public static void main(String[] args) {
		System.out.println(solution("FRANCE", "french"));
		System.out.println(solution("handshake", "shake hands"));
		System.out.println(solution("aa1+aa2", "AAAA12"));
		System.out.println(solution("E=M*C^2", "e=m*c^2"));
	}
}
