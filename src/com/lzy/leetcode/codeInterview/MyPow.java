package com.lzy.leetcode.codeInterview;
/**
 * 剑指offer  面试题16. 数值的整数次方
 * */
public class MyPow {
    public double myPow(double x, int n) {
        if(n == 0) return 1;
        if(n == 1) return x;
        if(n == -1) return 1 / x;
        double half = myPow(x, n / 2);
        double mod = myPow(x, n % 2);
        return half * half * mod;
    }

    public static void main(String[] args){
        System.out.println(new MyPow().myPow(2,-2147483648));
    }

}
