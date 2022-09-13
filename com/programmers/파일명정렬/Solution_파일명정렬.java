package com.programmers.파일명정렬;

import java.util.Arrays;

public class Solution_파일명정렬 {
	public static class FileName implements Comparable<FileName>{
		String HEAD;
    	int NUMBER;
    	String TAIL;
    	String name;
    	
    	public FileName(String a, String b, String c, String n) {
    		this.HEAD = a;
    		this.NUMBER = Integer.parseInt(b);
    		this.TAIL= c;
    		this.name = n;
    	}
    	
    	@Override
    	public int compareTo(FileName o) {
			int res = this.HEAD.compareTo(o.HEAD);
			if(res != 0) return res;
			return this.NUMBER - o.NUMBER;
		}
	}
	public static String[] solution(String[] files) {
		int N = files.length;
        String[] answer = new String[N];
        FileName[] names = new FileName[N];
        for(int i = 0; i < N; i++) {
        	String file = files[i];
        	file = file.trim();
        	String HEAD = "";
        	String NUMBER = "";
        	String TAIL = "";
        	int idx = 0;
        	while(idx < file.length()){
        		if(Character.isDigit(file.charAt(idx))){
        			HEAD = file.substring(0, idx);
        			HEAD = HEAD.toLowerCase();
        			break;
        		}
        		idx++;
        	}
        	int idx2 = idx;
        	while(idx2 < file.length() && idx2 < idx + 5) {
        		if(!Character.isDigit(file.charAt(idx2))) break;
        		idx2++;
        	}
        	NUMBER = file.substring(idx, idx2);
        	TAIL = file.substring(idx2);
        	FileName name = new FileName(HEAD, NUMBER, TAIL, file);
        	names[i] = name;
        }
        Arrays.sort(names);
        for(int i = 0; i < N; i++) {
        	answer[i] = names[i].name;
        }
        return answer;
    }
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new String[] {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"})));
		System.out.println(Arrays.toString(solution(new String[] {"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"})));
		System.out.println(Arrays.toString(solution(new String[] {"img000012345", "img1.png","img2","IMG02"})));
	}
}
