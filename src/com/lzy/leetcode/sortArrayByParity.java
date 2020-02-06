package com.lzy.leetcode;

/**
 * LeetCode：按奇偶排序数组  题目编号： 905
 * 结题思路： 用两个指针分别指向数组的头部和尾部，从两端向中间移动、交换
 * */
public class sortArrayByParity {

    public static void main(String[] args){
        int[] A = {3,1,2,4};
        A = new sortArrayByParity().sortArrayByParity(A);
        for (int a : A){
            System.out.print(a+",");
        }
    }

    public int[] sortArrayByParity(int[] A) {
        int low = 0, high = A.length-1;
        while (high > low){
            if (A[low] % 2 != 0 && A[high] % 2 == 0){
                int t = A[low];
                A[low] = A[high];
                A[high] = t;
            }
            else if (A[low] % 2 == 0) low++;
            else if (A[high] % 2 != 0) high--;
        }
        return A;
    }
}
