package com.lzy.leetcode;

import java.util.HashSet;
import java.util.Set;
/**
 * LeetCode:无重复字符的最长子串 题目编号：3
 * 注意事项：使用暴力破解法，遍历所有的字串，获取最长的无重复字串的长度，时间复杂度过高
 * 这道题使用滑动窗口的概念，i和j分别向字符串的右侧滑动，将字符分别放入Set中，寻找最长的字符串
 *
 * */
public class lengthOfLongestSubstring {

    public static void main(String[] args){
        System.out.println(new lengthOfLongestSubstring().lengthOfLongestSubstring("pwwkew"));
    }

    public int lengthOfLongestSubstring(String s) {

        Set<Character> set = new HashSet<Character>();
        int i=0,j=0,max=0;
        while (i<s.length() && j< s.length()){
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                max = Math.max(max,j-i);
            }else {
                set.remove(s.charAt(i++));
            }
        }

        return max;
    }

}
