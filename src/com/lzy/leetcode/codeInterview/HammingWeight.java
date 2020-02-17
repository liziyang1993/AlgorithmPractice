package com.lzy.leetcode.codeInterview;
/**
 * 剑指offer 面试题15. 二进制中1的个数
 * */
public class HammingWeight {

    public int hammingWeight(int n) {
        String binary = Integer.toBinaryString(n);
        int num = 0;
        for(char c : binary.toCharArray()){
            if (c == '1') num++;
        }
        return num;
    }

    public static void main(String[] args){
        System.out.println(new HammingWeight().hammingWeight(10));
    }
}
