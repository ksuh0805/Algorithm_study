package com.programmers.캐시;

import java.util.LinkedList;

public class Solution_캐시 {
	public static int solution(int cacheSize, String[] cities) {
        int answer = 0;
        if(cacheSize == 0) return cities.length * 5;
        LinkedList<String> list = new LinkedList<>();
        for(int i = 0; i < cities.length; i++) {
        	String city = cities[i];
        	city = city.toLowerCase();
        	if(list.contains(city)) {
        		list.remove(list.indexOf(city));
        		list.addFirst(city);
        		answer++;
        	}else {
        		if(list.size() < cacheSize) {
        			list.addFirst(city);
        		}else {
        			list.removeLast();
        			list.addFirst(city);
        		}
        		answer += 5;
        	}
        }
        return answer;
    }
	public static void main(String[] args) {
		System.out.println(solution(3, new String[] {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"}));
		System.out.println(solution(3, new String[] {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"}));
		System.out.println(solution(2, new String[] {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"}));
		System.out.println(solution(5, new String[] {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"}));
		System.out.println(solution(2, new String[] {"Jeju", "Pangyo", "NewYork", "newyork"}));
		System.out.println(solution(0, new String[] {"Jeju", "Pangyo", "Seoul", "NewYork", "LA"}));
	}
}
