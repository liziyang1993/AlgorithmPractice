package com.lzy.leetcode.codeInterview;
/**
 * LeetCode上《剑指offer》面试题21. 调整数组顺序使奇数位于偶数前面
 * 核心思想：先统计数组中奇数的个数，让后用双指针的方式进行交换
 * */
public class Exchange {
    public int[] exchange(int[] nums) {

        int odd = 0;
        for (int i : nums) {
            if (i % 2 != 0) odd++;
        }
        int i = 0, j = odd;
        while (i < odd && j < nums.length) {
            while (i < odd && nums[i] % 2 != 0) i++;
            while (j < nums.length && nums[j] % 2 == 0) j++;
            if (i >= odd || j >= nums.length)break;
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(new Exchange().exchange(nums));
    }
}
