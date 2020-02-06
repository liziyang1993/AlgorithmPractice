package com.lzy.sort;

public class CountSort {

    public int[] countSort(int[] nums){
        int max = 0, min = 0;
        for(int i = 0; i < nums.length; i++){
            if (nums[i] > max) max = nums[i];
            if (nums[i] < min) min = nums[i];
        }
        int[] data = new int[max-min+1];
        for(int i = 0; i < nums.length; i++){
            data[nums[i]-min]++;
        }
        for (int i=0,j=0;i < data.length;i++){
            for (int k = 1; k <= data[i]; k++){
                nums[j++] = min+i;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = SortHelper.generateRandomArray(20,100);
        System.out.println("计数排序");
        System.out.println("排序之前：");
        for (int i : nums) System.out.print(i + ",");
        nums = new CountSort().countSort(nums);
        System.out.println("\n排序之后：");
        for (int i : nums) System.out.print(i + ",");
    }
}
