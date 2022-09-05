package com.programmers._2개이하로다른비트;

public class Solution_2개이하로다른비트 {
	public static long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for(int i = 0; i < numbers.length; i++) {
        	long n = numbers[i];
        	String res = "0" + Long.toString(n, 2);
        	char[] str = res.toCharArray();
        	for(int j = str.length - 1; j >= 0; j--) {
        		if(str[j] == '0') {
        			str[j] = '1';
        			if(j != str.length - 1) {
        				str[j + 1] = '0';
        			}
        			break;
        		}
        	}
        	res = String.valueOf(str);
        	answer[i] = Long.parseLong(res, 2);
        }
        return answer;
    }
	public static void main(String[] args) {
		long[] result = solution(new long[] {2, 7});
		for(long n : result) {
			System.out.print(n + " ");
		}
	}
}
