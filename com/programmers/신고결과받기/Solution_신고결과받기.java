package com.programmers.신고결과받기;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

public class Solution_신고결과받기 {
	public static int[] solution(String[] id_list, String[] report, int k) {
		int n = id_list.length;
        int[] answer = new int[n];
        HashSet<String>[] sets = new HashSet[n];
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
        	sets[i] = new HashSet<String>();
        	map.put(id_list[i], i);
        }
        for(int i = 0; i < report.length; i++) {
        	String[] ss = report[i].split(" ");
        	String id = ss[0];
        	String target = ss[1];
        	int index = map.get(id);
        	sets[index].add(target);
        }
        Map<String, Integer> cnt = new HashMap<>();
        for(int i = 0; i < n; i++) {
        	String id = id_list[i];
        	int index = map.get(id);
        	Iterator it = sets[index].iterator(); 
			while (it.hasNext()) { // set에 요소가 있을 때까지 반복
				String s = (String) it.next();
				cnt.put(s, cnt.getOrDefault(s, 0) + 1);
			}
        }
        for(int i = 0; i < n; i++) {
        	String id = id_list[i];
        	int index = map.get(id);
        	Iterator it = sets[index].iterator();
        	int ans = 0;
			while (it.hasNext()) { // set에 요소가 있을 때까지 반복
				String s = (String) it.next();
				if(cnt.getOrDefault(s, 0) >= k) ans++;
			}
			answer[i] = ans;
        }
        return answer;
    }
	public static void main(String[] args) {
		int[] result = solution(new String[] {"muzi", "frodo", "apeach", "neo"}, new String[] {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"}, 2);
		int[] result2 = solution(new String[] {"con", "ryan"}, new String[] {"ryan con", "ryan con", "ryan con", "ryan con"}, 2);
		for(int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
		System.out.println();
		for(int i = 0; i < result2.length; i++) {
			System.out.print(result2[i] + " ");
		}
	}
}
