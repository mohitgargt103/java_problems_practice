package com.mohit.leetcode.array.medium;

/*
Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container and n is at least 2.





The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.



Example:

Input: [1,8,6,2,5,4,8,3,7]
Output: 49
https://leetcode.com/problems/container-with-most-water/
 */
public class ContainerWithMostWater {

    public static void main(String[] args) {
        ContainerWithMostWater mostWater = new ContainerWithMostWater();
        System.out.println(mostWater.maxArea(new int[]{1, 3, 5, 7, 2}));
    }

    public int maxArea(int[] height) {
        if (height == null || height.length == 0)
            return 0;

        int max = 0;
        int l = 0;
        int r = height.length - 1;
        while (l < r) {
            max = Math.max(max, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return max;
    }
}
