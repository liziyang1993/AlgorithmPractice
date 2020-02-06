package com.lzy.leetcode;

/**
 * LeetCode 斐波那契数 题目编号：509
 * 递归解法
 * */
public class Fib {
    public static void main(String[] args){
        System.out.println(new Fib().fib(4));
    }

    public int fib(int N) {
        if (N == 0) return 0;
        if (N == 1) return 1;
        return fib(N-1) + fib(N-2);
    }

}
