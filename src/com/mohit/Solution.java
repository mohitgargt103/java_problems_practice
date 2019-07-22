package com.mohit;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while (t > 0) {
            int n = s.nextInt();
            Integer a = null;
            Integer b = null;
            for (int i = 0; i < n; i++) {
                int val = s.nextInt();
                if (a == null || a > val) {
                    b = a;
                    a = val;
                } else if (b == null || b > val) {
                    b = val;
                }
            }
            System.out.println(String.format("%d", (a + b)));
            t--;
        }
    }
}
