/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mohit.leetcode.strings.medium;

/**
 * @author Mohit Garg
 */
public class ReverseWordsinaString {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ReverseWordsinaString problems = new ReverseWordsinaString();
        String string = "           the sky     is       blue";
        System.out.println(problems.reverseWords(string));
    }

    public String reverseWords(String s) {
        StringBuilder builder = new StringBuilder();
        char[] ch = s.toCharArray();
        int n = ch.length - 1;
        for (int i = n; i >= 0; ) {
            while (i >= 0 && ch[i] == ' ') {
                i--;
            }
            int start = i;
            while (i >= 0 && ch[i] != ' ') {
                i--;
            }

            builder.append(s.substring(i + 1, start + 1));
            builder.append(" ");
        }
        return builder.toString().trim();
    }

    /*public String reverseWords(String s) {
        if (s.length() == 0) {
            return s;
        }
        s = s.trim();
        if (s.length() == 1) {
            return s;
        }
        // remove extra Space 
        int length = s.length();
        StringBuilder sb = new StringBuilder();
        for (int i = length - 1; i >= 0; i--) {
            int start = i;
            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
            }
            if (i + 1 == start + 1) {
                continue;
            }
            String temp = s.substring(i + 1, start + 1);
            sb.append(temp);
            sb.append(" ");
        }
        return sb.toString().trim();
    }*/

}
