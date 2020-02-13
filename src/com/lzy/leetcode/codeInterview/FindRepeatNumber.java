package com.lzy.leetcode.codeInterview;
/**
 * LeetCode中《剑指offer》 面试题03. 数组中重复的数字
 *
 * */
public class FindRepeatNumber {
    public int findRepeatNumber(int[] nums) {

        int[] nums1 = new int[nums.length];

        for (int i : nums){
            if (nums1[i]>0) return i;
            nums1[i] = 1;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 0, 2, 5, 3};
        System.out.println(new FindRepeatNumber().findRepeatNumber(nums));
    }
}
