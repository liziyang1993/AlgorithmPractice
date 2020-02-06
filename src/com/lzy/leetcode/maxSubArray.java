package com.lzy.leetcode;

public class maxSubArray {
    public static void main(String[] args){
        int[] nums = {-2,3,-4};
        System.out.println(new maxSubArray().maxSubArray(nums));
    }

    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length],dpmin= new int[nums.length];
        dp[0] = nums[0];
        dpmin[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < nums.length; i++){
            dp[i] = Math.max(Math.max(dp[i-1]*nums[i],dpmin[i-1]*nums[i]),nums[i]);
            dpmin[i] = Math.min(Math.min(dp[i-1]*nums[i],dpmin[i-1]*nums[i]),nums[i]);
            max = Math.max(max,dp[i]);
        }
        return max;
    }
}
