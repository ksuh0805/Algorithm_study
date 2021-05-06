package com.programmers.위장;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution_위장 {
	public static int solution(String[][] clothes) {
        int answer = 0;
        Map<String, Integer> cloth = new HashMap<>();
        for(int i = 0; i < clothes.length; i++) {
        	cloth.put(clothes[i][1], cloth.getOrDefault(clothes[i][1], 0) + 1);
        }
        Set set = cloth.keySet();
        List<Integer> list = new ArrayList<>();
        Iterator itr = set.iterator();
        while(itr.hasNext()) {
        	String key = (String)itr.next();
        	list.add(cloth.get(key));
        }
        answer = list.get(0) + 1;
        for(int i = 1; i < list.size(); i++) {
        	answer *= list.get(i) + 1;
        }
        return answer - 1;
    }
	public static void main(String[] args) {
		System.out.println(solution(new String[][] {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}}));
		System.out.println(solution(new String[][] {{"crowmask", "face"}, {"bluesunglasses", "face"}, {"smoky_makeup", "face"}}));
	}
}
