package com.mohit;

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 3, 5, 1, 2}));
    }
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed.length != popped.length) return false;
        Stack<Integer> push = new Stack<>();
        int i = 0;
        int j = 0;
        while (i < pushed.length) {
            push.push(pushed[i]);
            while (j < popped.length && popped[j] == push.peek()) {
                push.pop();
                j++;
            }
            i++;
        }
        while (j < popped.length && !push.isEmpty() && push.peek() == popped[j]) {
            push.pop();
            j++;
        }
        if (j < popped.length || !push.isEmpty()) return false;

        return true;
    }
}