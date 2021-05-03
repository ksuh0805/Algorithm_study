package com.programmers.카펫;

public class Solution_카펫 {
	public static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        // garo * 2 + (sero - 2) * 2 = brown
        // (garo - 2) * (sero - 2) = yellow
        outer:
        for(int i = 3; i < brown / 2; i++) {
        	for(int j = 3; j < brown / 2; j++) {
        		if(i * 2 + (j - 2) * 2 == brown 
        				&& (i - 2) * (j - 2) == yellow) {
        			answer[0] = j;
        			answer[1] = i;
        			break outer;
        		}
        	}
        }
        return answer;
    }
	public static void main(String[] args) {
		System.out.println(solution(10, 2)[0]);
		System.out.println(solution(10, 2)[1]);
		System.out.println(solution(8, 1)[0]);
		System.out.println(solution(8, 1)[1]);
		System.out.println(solution(24, 24)[0]);
		System.out.println(solution(24, 24)[1]);
	}
}
