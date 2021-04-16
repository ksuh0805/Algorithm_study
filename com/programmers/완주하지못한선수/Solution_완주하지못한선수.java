package com.programmers.완주하지못한선수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution_완주하지못한선수 {

	public static String solution(String[] participant, String[] completion) {
//	    ArrayList<String> list = new ArrayList<>();
//	    for(String s : completion) {
//	    	list.add(s);
//	    }
//	    for(String s : participant) {
//	    	if(!list.contains(s)) return s;
//	    	else list.remove(s);
//	    }
	    Arrays.sort(participant);
	    Arrays.sort(completion);
	    for(int i = 0; i < completion.length; i++) {
	    	if(!participant[i].equals(completion[i])) return participant[i];
	    }
	    return participant[participant.length - 1];
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		String[] participant = new String[N];
		String[] completion = new String[M];
		for(int i = 0; i < N; i++) {
			participant[i] = br.readLine();
		}
		for(int i = 0; i < M; i++) {
			completion[i] = br.readLine();
		}
		System.out.println(solution(participant, completion));
	}
}
