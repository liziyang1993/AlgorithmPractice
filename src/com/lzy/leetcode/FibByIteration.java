package com.lzy.leetcode;
/**
 * LeetCode 斐波那契数 题目编号：509
 * 非递归解法，效率更高，时间复杂度为O(n),空间复杂度为O(1)，不使用数组或map记录中间结果
 * */
public class FibByIteration {
    public static void main(String[] args){
        System.out.println(new FibByIteration().fib(45));
    }

    public int fib(int N) {
        if (N < 2) return N;
        int fibNminusTwo = 0, fibNminusOne = 1, fib = 0;
        for (int i = 2; i <= N; i++){
            fib = fibNminusOne + fibNminusTwo;
            fibNminusTwo = fibNminusOne;
            fibNminusOne = fib;
        }
        return fib%1000000007;
    }
}














