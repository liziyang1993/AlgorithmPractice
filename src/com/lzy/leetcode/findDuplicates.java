package com.lzy.leetcode;

import java.util.ArrayList;
import java.util.List;
/**
 * LeetCode： 数组中重复的数据 题目编号：442
 * 解题技巧：由于不能使用额外的空间，则将数组下标对应的数变为负数，则连续两次变为负数的数据为重复数据
 * 注意：可能出现下标越界的问题，需要减1
 * */

public class findDuplicates {
    public static void main(String[] args){

    }

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i : nums){
            if(nums[Math.abs(i)-1] < 0){
                list.add(Math.abs(i));
            } else {
                nums[Math.abs(i)-1] = - nums[Math.abs(i)-1];
            }
        }
        return list;
    }
}
