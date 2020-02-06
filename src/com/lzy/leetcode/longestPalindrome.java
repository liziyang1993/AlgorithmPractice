package com.lzy.leetcode;

/**
 * LeetCode 最长回文字串 题目编号  5
 * 解题思路：动态规划，通过填写布尔类型的二维矩阵，自下而上的解决问题
 * 核心代码： if (s.charAt(i) == s.charAt(j) && dp[i+1][j-1])  dp[i][j] = true;
 * */
public class longestPalindrome {
    public static void main(String[] args){
        System.out.println(new longestPalindrome().longestPalindrome("cbbd"));
    }

    public String longestPalindrome(String s) {
        if (s == null || s.equals("")) return "";
        boolean[][] dp = new boolean[s.length()][s.length()];
        int left = 0, right = 0;
        for (int i = 0; i < s.length(); i++){
            dp[i][i] = true;
            if (i < s.length()-1 && s.charAt(i) == s.charAt(i+1)){
                dp[i][i+1] = true;
                left = i;
                right = i + 1;
            }
        }

        for (int l = 3; l <= s.length(); l++){
            for (int i = 0; i+l-1 < s.length(); i++){
                int j = i + l - 1;
                if (s.charAt(i) == s.charAt(j) && dp[i+1][j-1]){
                    dp[i][j] = true;
                    if (right - left + 1 < l){
                        left = i;
                        right = j;
                    }
                }
            }
        }

        return s.substring(left,right+1);
    }
}
