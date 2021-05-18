package com.programmers.실패율;

import java.util.PriorityQueue;

public class Soluton_실패율 {
	public static class Stage implements Comparable<Stage>{
        int stage;
        double failure;
        
        public Stage(int stage, double failure){
            this.stage = stage;
            this.failure = failure;
        }
        
        @Override
        public int compareTo(Stage o){
            if(this.failure > o.failure) return -1;
            else if(this.failure < o.failure) return 1;
            else return this.stage - o.stage;
        }
    }
    public static int[] solution(int N, int[] stages) {
        int n = stages.length;
        int[] answer = new int[N];
        int[] stage_num = new int[N + 2];
        for(int i = 0; i < n; i++){
            stage_num[stages[i]]++;
        }
        int[] accu = new int[N + 1];
        for(int i = 1; i < N + 1; i++){
            accu[i] = accu[i - 1] + stage_num[i];
        }
        PriorityQueue<Stage> pq = new PriorityQueue<>();
        for(int i = 1; i < N + 1; i++){
            double failure = 0;
            if(n - accu[i - 1] != 0) {
            	failure = (double)stage_num[i] / (n - accu[i - 1]);
            }
            pq.offer(new Stage(i, failure));
        }
        for(int i = 0; i < N; i++){
            answer[i] = pq.poll().stage;
        }
        return answer;
    }
    public static void main(String[] args) {
		int[] arr = solution(5, new int[] {2, 1, 2, 6, 2, 4, 3, 3});
		for(int a : arr) {
			System.out.print(a + " ");
		}
		System.out.println();
		arr = solution(4, new int[] {4,4,4,4,4});
		for(int a : arr) {
			System.out.print(a + " ");
		}
	}
}