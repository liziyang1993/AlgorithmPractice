package com.lzy.search;

/**
 * LeetCode 二分查找  题目编号  704
 * 注意循环边界的处理，注意特殊情况的处理
 * 细节： left = midle+1; right = midle-1;
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 2;
        System.out.println(new BinarySearch().search(nums, target));
    }

    public int search(int[] nums, int target) {

        int left = 0, right = nums.length - 1;
        if (nums.length == 0 || target > nums[right] || target < nums[0]) return -1;
        if (nums.length == 1) {
            if (nums[0] == target) return 0;
            else return -1;
        }
        while (right >= left) {
            int midle = (right + left) / 2;
            if (nums[midle] == target) return midle;
            if (nums[midle] < target) left = midle + 1;
            else if (nums[midle] > target) right = midle - 1;
        }

        return -1;
    }
}
