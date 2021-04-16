package com.baekjoon.컨베이어벨트위의로봇20055;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_20055_컨베이어벨트위의로봇 {
	static int N, K;
	static int[] arr, robot;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[2 * N];
		robot = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 2 * N; i++) {
			arr[i] =Integer.parseInt(st.nextToken());
		}
		int cnt = 0;
		while(!check()) {
			rotate();
			cnt++;
		}
		System.out.println(cnt);
	}
	private static void rotate() {
		int temp = arr[2 * N - 1];
		for(int i = 2 * N - 1; i > 0; i--) {
			arr[i] = arr[i - 1];
		}
		for(int i = N - 1; i > 0; i--) {
			robot[i] = robot[i - 1];
		}
		robot[0] = 0;
		arr[0] = temp;
		if(robot[N - 1] == 1) robot[N - 1] = 0;
		for(int i = N - 1; i > 0; i--) {
			if(robot[i - 1] != 0 && robot[i] == 0 && arr[i] > 0) {
				robot[i] = robot[i - 1];
				robot[i - 1] = 0;
				arr[i]--;
			}
		}
		if(arr[0] > 0) {
			robot[0] = 1;
			arr[0]--;
		}
	}
	private static boolean check() {
		int count = 0;
		for(int i = 0; i < 2 * N; i++) {
			if(arr[i] == 0) count++;
			if(count >= K) return true;
		}
		return false;
	}
}
