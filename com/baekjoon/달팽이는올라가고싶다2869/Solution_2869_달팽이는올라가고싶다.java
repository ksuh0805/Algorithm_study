package com.baekjoon.달팽이는올라가고싶다2869;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2869_달팽이는올라가고싶다 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        int cnt = 0;
        int temp = V - A;
        cnt = temp / (A - B);
        if(temp % (A - B) != 0) cnt++;
        System.out.println(cnt + 1);
    }
}
