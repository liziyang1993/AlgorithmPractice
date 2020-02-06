package com.lzy.sort;

public class QuickSort {

    //单向扫描的partition函数
    private int partition(int[] nums, int left, int right){
        int pivot = nums[right];
        int i = left, j = left;
        for (; j < right; j++){
            if (nums[j] < pivot){
                if (i != j){
                    int t = nums[i];
                    nums[i]= nums[j];
                    nums[j] = t;
                }
                i++;
            }
        }
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
        return i;
    }

    public int[] quickSort(int[] nums, int left, int right){

        if (nums == null || nums.length == 0) return null;
        if (left > right) return nums;

        int index = partition(nums, left, right);
        if (index > left) quickSort(nums, left, index-1);
        if (index < right) quickSort(nums,index+1,right);

        return nums;
    }

    public static void main(String[] args) {
        int[] nums = SortHelper.generateRandomArray(100,100);
        System.out.println("快速排序");
        System.out.println("排序之前：");
        for (int i : nums) System.out.print(i + ",");
        nums = new QuickSort().quickSort(nums,0,nums.length-1);
        System.out.println("\n排序之后：");
        for (int i : nums) System.out.print(i + ",");
    }
}
