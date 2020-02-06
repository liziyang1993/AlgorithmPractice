package com.lzy.leetcode;

/**
 * LeetCode题目：整数翻转  题目编号：7
 * 需要注意的地方：
 * 1. 输入整数中间有0和末尾有0的情况，需要单独考虑
 * 2. 数据可能超过32位整型，但超过32位的数据不做处理，直接返回0.因此需要用long类型接受输入数据
 *    判断计算结果超出32位整型的，直接返回0.
 * */
public class Reverse {
    public static void main(String[] args){
        System.out.println(new Reverse().reverse(-2147483648));;
    }
    public int reverse(long x) {
        if (x>Integer.MAX_VALUE || x <Integer.MIN_VALUE)return 0;
        int s=Math.abs((int) x);
        int num[]= new int[1000],i=0;
        long answer =0;
        while (s>9){
            num[i++] = s % 10;
            s = s / 10;
        }
        num[i++] = s;
        for (int j=0; j<i;j++){
            answer = answer * 10 + num[j];
        }
        if (answer>=Integer.MAX_VALUE || answer <=Integer.MIN_VALUE)return 0;
        if (x >0)return (int) answer;
        else  return (int)-answer;
    }
}
