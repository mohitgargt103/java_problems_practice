package com.mohit.leetcode.array.medium;

import com.mohit.sorting.PrintArray;

/*
Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Example:

Input:  [1,2,3,4]
Output: [24,12,8,6]
Note: Please solve it without division and in O(n).

Follow up:
Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)
 */
public class ProductofArrayExceptSelf {
    public static void main(String[] args) {
        ProductofArrayExceptSelf exceptSelf = new ProductofArrayExceptSelf();
        new PrintArray().printSingleArray(exceptSelf.productExceptSelf(new int[]{9, 0, -2}));
    }

    public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];
        if (nums.length == 0) {
            return output;
        }
        for (int i = 0; i < nums.length; i++) {
            output[i] = (i == 0) ? 1 : (i == 1) ? nums[i - 1] : output[i - 1] * nums[i - 1];
        }
        int product = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            output[i] = output[i] * product;
            product *= nums[i];
        }
        return output;
    }


}
