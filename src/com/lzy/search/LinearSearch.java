package com.lzy.search;

public class LinearSearch {

    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 3;
        System.out.println(new LinearSearch().search(nums, target));
    }

    public int search(int[] nums, int target) {
        if (nums == null || nums.length <= 0) return -1; //首先过滤非法输入的情况
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) return i;
        }
        return -1;
    }
}
