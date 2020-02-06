package com.lzy.leetcode;

/**
 * LeetCode题目：回文数 题目编号：9
 * 注意：判断输入数据为0的情况，需要做简单考虑。
 * */
public class IsPalindrome {

    public static void main(String[] args){
        System.out.println(new IsPalindrome().isPalindrome(0));
    }

    public boolean isPalindrome(int x) {
        if (x<0) return false;
        int[] num = new int[10000];
        int i = 0;
        while (x >0){
            num[i++] = x%10;
            x /= 10;
        }

        i--;
        for (int j=0;j!=i && i>=0;j++,i--){
            if (num[j]!=num[i]) return false;
        }


        return true;
    }
}
