package com.leetcode.ContainerWithMostWater;

public class Solution_ContainerWithMostWater {
	public static int maxArea(int[] height) {
		/*
		int len = height.length;
		int max = 0;
		for(int i = 0; i < len - 1; i++) {
			for(int j = i + 1; j < len; j++) {
				int s = (j - i) * Math.min(height[i], height[j]);
				max = Math.max(max, s);
			}
		}
		return max;
		*/
		int start = 0;
        int last = height.length - 1;
        int max = 0;
        while(last - start > 0){
            int h = Math.min(height[start], height[last]);
            int s = (last - start) * h;
            max = Math.max(max, s);
            if(height[start] > height[last]) last--;
            else start++;
        }
        return max;
    }
	public static void main(String[] args) {
		System.out.println(maxArea(new int[] {1, 8, 6, 2, 5, 4, 8, 3, 7}));
		System.out.println(maxArea(new int[] {1, 1}));
	}
}
