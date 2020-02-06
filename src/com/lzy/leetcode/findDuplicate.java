package com.lzy.leetcode;

/**
 * LeetCode： 寻找重复数  题目编号：287
 * 思路：使用类似于二分查找的方法，不断缩小重复数可能出现的区间，缩小范围直到找到重复的数
 * 关键点：不能改变数组的内容，因此通过二分法统计数据区间出现的频次
 * */

public class findDuplicate {
    public static void main(String[] args){
        int[] nums = {3,1,3,4,2};
        System.out.println(new findDuplicate().findDuplicate(nums));
    }

    public int findDuplicate(int[] nums) {
        int low = 1, high = nums.length-1;
        while (high > low){
            int midle = (low + high) / 2;
            if (countRange(nums,low,midle)> (midle-low+1)){
                high = midle;
            }else {
                low = midle+1;
            }
        }
        return high;
    }

    public int countRange(int[] nums,int low, int high){
        int count = 0;
        for (int i : nums){
            if (i >= low && i <= high) count++;
        }
        return count;
    }


}
