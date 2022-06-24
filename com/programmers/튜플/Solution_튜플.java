package com.programmers.튜플;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Solution_튜플 {
	public static int[] solution(String s) {
        int[] answer = {};
        s = s.replaceAll("\\},\\{", " ");
        s = s.replaceAll("\\}", "");
        s = s.replaceAll("\\{", "");
        String[] ss = s.split(" ");
        Arrays.sort(ss, new Comparator<String>() {
        	@Override
        	public int compare(String o1, String o2) {
        		return o1.length() - o2.length();
        	}
        });
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < ss.length; i++) {
        	String[] sss = ss[i].split(",");
        	for(int j = 0; j < sss.length; j++) {        		
        		int n = Integer.parseInt(sss[j]);
        		if(!list.contains(n)) list.add(n);
        	}
        }
        answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
        	answer[i] = list.get(i);
        }
        return answer;
    }
	public static void main(String[] args) {
		int[] ans = solution("{{2},{2,1},{2,1,3},{2,1,3,4}}");
		for(int i = 0; i < ans.length; i++) {
			System.out.print(ans[i] + " ");
		}
		System.out.println();
		ans = solution("{{1,2,3},{2,1},{1,2,4,3},{2}}");
		for(int i = 0; i < ans.length; i++) {
			System.out.print(ans[i] + " ");
		}
		System.out.println();
		ans = solution("{{20,111},{111}}");
		for(int i = 0; i < ans.length; i++) {
			System.out.print(ans[i] + " ");
		}
		System.out.println();
		ans = solution("{{123}}");
		for(int i = 0; i < ans.length; i++) {
			System.out.print(ans[i] + " ");
		}
		System.out.println();
		ans = solution("{{4,2,3},{3},{2,3,4,1},{2,3}}");
		for(int i = 0; i < ans.length; i++) {
			System.out.print(ans[i] + " ");
		}
		System.out.println();
	}
}
