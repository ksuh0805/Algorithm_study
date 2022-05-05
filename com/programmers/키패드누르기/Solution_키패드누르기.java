package com.programmers.키패드누르기;

public class Solution_키패드누르기 {
	public static String solution(int[] numbers, String hand) {
        String answer = "";
        int lx = 3;
        int ly = 0;
        int rx = 3;
        int ry = 2;
        for(int i = 0; i < numbers.length; i++) {
        	int n = numbers[i];
        	if(n == 1 || n == 4 || n == 7) {
        		answer += "L";
        		if(n == 1) lx = 0;
        		else if(n == 4) lx = 1;
        		else lx = 2;
        		if(ly != 0) ly = 0;
        	}
        	else if(n == 3 || n == 6 || n == 9) {
        		answer += "R";
        		if(n == 3) rx = 0;
        		else if(n == 6) rx = 1;
        		else rx = 2;
        		if(ry != 0) ry = 2;
        	}
        	else {
        		int cy = 1;
        		int cx = 3;
        		if(n == 2) cx = 0;
        		else if(n == 5) cx = 1;
        		else if(n == 8) cx = 2;
        		int dl = Math.abs(cx - lx) + Math.abs(cy - ly);
        		int dr = Math.abs(cx - rx) + Math.abs(cy - ry);
        		if(dl < dr || (dl == dr && hand.equals("left"))) {
        			lx = cx;
        			ly = cy;
        			answer += "L";
        		}else if(dl > dr || (dl == dr && hand.equals("right"))) {
        			rx = cx;
        			ry = cy;
        			answer += "R";
        		}
        	}
        }
        return answer;
    }
	public static void main(String[] args) {
		System.out.println(solution(new int[] {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, "right"));
		System.out.println(solution(new int[] {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2}, "left"));
		System.out.println(solution(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 0}, "right"));
	}
}
