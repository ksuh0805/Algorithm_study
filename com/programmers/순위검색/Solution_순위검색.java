package com.programmers.순위검색;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Solution_순위검색 {
	public static int[] solution(String[] info, String[] query) {
		int n = info.length;
		Map<String, ArrayList<Integer>> map = new HashMap<>();
		for(int i = 0; i < n; i++) {
			String[] s = info[i].split(" ");
			String[] aa = {s[0], "-"};
			String[] bb = {s[1], "-"};
			String[] cc = {s[2], "-"};
			String[] dd = {s[3], "-"};
			for(String a : aa) {
				for(String b : bb) {
					for(String c : cc) {
						for(String d : dd) {
							String in = a + b + c + d;
							int score = Integer.parseInt(s[4]);
							ArrayList<Integer> list = map.getOrDefault(in, new ArrayList<Integer>());
							list.add(score);
							map.put(in, list);
						}
					}
				}				
			}
		}
		for(String s : map.keySet()) {
			Collections.sort(map.getOrDefault(s, new ArrayList<Integer>()));
		}
		int len = query.length;
		int[] result = new int[len];
		for(int i = 0; i < len; i++) {
			String qr = query[i].replaceAll("and ", "");
			String[] q = qr.split(" ");
			String qs = q[0] + q[1] + q[2] + q[3];
			int target = Integer.parseInt(q[4]);
			
			if(map.containsKey(qs)){
                if(map.get(qs).size() == 1){//1개일 경우 
                    if(target <= map.get(qs).get(0)) result[i] = 1;
                    }else{//1개 이상일 경우 이분 탐색
                        int min = 0;
                        int max = map.get(qs).size() - 1;
                        int mid;

                        while(min <= max){
                            mid = (min + max) / 2;
                            if (map.get(qs).get(mid) < target) min = mid + 1;
                            else max = mid - 1;
                        }
                    result[i] = map.get(qs).size() - min;
                }
            }
		}
		
		return result;
	}
	public static void main(String[] args) {
		int[] ans = solution(new String[] {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"}
		, new String[] {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"});
		for(int i = 0; i < ans.length; i++) {
			System.out.print(ans[i] + " ");
		}
	}
}
