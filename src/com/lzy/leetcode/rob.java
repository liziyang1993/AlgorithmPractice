package com.lzy.leetcode;

public class rob {
    public static void main(String[] args){
        int nums[] = {6,6,4,8,4,3,3,10};
        System.out.println(new rob().rob(nums));
    }

    public int rob(int[] nums) {
        int[] nums1 = new int[nums.length-1], nums2 = new int[nums.length-1];
        for (int i = 0; i < nums.length - 1; i++){
            nums1[i] = nums[i];
        }
        for (int i = 1; i < nums.length; i++){
            nums2[i-1] = nums[i];
        }
        return Math.max(dp(nums1),dp(nums2));
    }

    public int dp(int[] nums){
        if (nums.length == 0)return 0;
        if (nums.length == 1)return nums[0];
        int dp[] = new int[nums.length];
        int max ;
        dp[0] = nums[0];
        dp[1] = nums[1];
        max = Math.max(dp[0],dp[1]);
        for (int i = 2 ; i < nums.length ;i++){
            dp[i] = dp[i-1];
            for (int j = 0 ; j <= i-2; j++){
                dp[i] = Math.max(dp[i],dp[j]+nums[i]);
            }
            max = Math.max(max,dp[i]);
        }
        return max;
    }
}
