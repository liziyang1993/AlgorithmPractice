package com.lzy.sort;

public class SelectionSort {

    public int[] selectionSort(int[] nums){

        if (nums == null || nums.length == 0) return null;

        for (int i = 0; i < nums.length; i++){
            int minIndex = i;
            for (int j = i+1; j < nums.length; j++){
                if (nums[j] < nums[minIndex]) minIndex = j;
            }
            if (minIndex != i){
                int t = nums[i];
                nums[i] = nums[minIndex];
                nums[minIndex] = t;
            }
        }

        return nums;
    }

    public static void main(String[] args) {
        int[] nums = SortHelper.generateRandomArray(10,100);
        System.out.println("选择排序");
        System.out.println("排序之前：");
        for (int i : nums) System.out.print(i + ",");
        nums = new SelectionSort().selectionSort(nums);
        System.out.println("\n排序之后：");
        for (int i : nums) System.out.print(i + ",");
    }
}
