package com.lzy.sort;
/**
 * 冒泡排序
 * 冒泡排序是排序算法中思想最简单的一种，通过多次比较数组中相邻的两个元素，将不符合顺序的元素进行两两交换，从而实现排序。 \
 * 平均时间复杂度：n平方
 * 最坏时间复杂度：n平方
 * 算法稳定性：稳定
 * */
public class BubbleSort {

    public int[] bubbuleSort(int[] nums){

        if (nums == null || nums.length == 0) return null;

        for (int i = 0; i < nums.length; i++){
            for (int j = 0; j < nums.length-i-1; j++){
                if (nums[j] > nums[j+1]) {
                    int t = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = t;
                }
            }
        }

        return nums;
    }

    public static void main(String[] args) {
        int[] nums = SortHelper.generateRandomArray(20,100);
        System.out.println("冒泡排序");
        System.out.println("排序之前：");
        for (int i : nums) System.out.print(i + ",");
        nums = new BubbleSort().bubbuleSort(nums);
        System.out.println("\n排序之后：");
        for (int i : nums) System.out.print(i + ",");
    }
}
