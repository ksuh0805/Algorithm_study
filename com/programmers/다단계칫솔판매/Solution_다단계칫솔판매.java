package com.programmers.다단계칫솔판매;

import java.util.HashMap;
import java.util.Map;

public class Solution_다단계칫솔판매 {
	static int N;
	static Map<String, Integer> idx;
	static String[] E, R;
	static int[] answer;
	public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
		N = enroll.length;
		answer = new int[N];
        idx = new HashMap<>();
        for(int i = 0; i < N; i++) {
        	idx.put(enroll[i], i);
        }
        E = new String[N];
        R = new String[N];
        for(int i = 0; i < N; i++) {
        	E[i] = enroll[i];
        	R[i] = referral[i];
        }
        for(int i = 0; i < seller.length; i++) {
        	calc(seller[i], amount[i] * 100);
        }
		
        return answer;
    }
	private static void calc(String s, int a) {
		int index = idx.get(s);
		Double up_d = a * 0.1;
		int up = up_d.intValue();
		int cur = a - up;
		answer[index] += cur;
		String reco = R[index];
		if(reco.equals("-")) return;
		if(up == 0) return;
		calc(reco, up);
	}
	public static void main(String[] args) {
		int[] result = solution(new String[] {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"}, new String[] {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"}, new String[] {"young", "john", "tod", "emily", "mary"}, new int[] {12, 4, 2, 5, 10});
		for(int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
		System.out.println();
		result = solution(new String[] {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"}, new String[] {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"}, new String[] {"sam", "emily", "jaimie", "edward"}, new int[] {2, 3, 5, 4});
		for(int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
	}
}
