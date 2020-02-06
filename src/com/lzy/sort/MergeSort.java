package com.lzy.sort;

public class MergeSort {

    public int[] mergeSort(int[] nums, int left, int right){

        if (left == right) return new int[] {nums[left]};

        int middle = (left + right) / 2;
        int[] leftArray = mergeSort(nums,left,middle);
        int[] rightArray = mergeSort(nums,middle+1,right);
        int[] newArray = new int[leftArray.length+rightArray.length];
        int i = 0, j = 0, k = 0;
        // i为leftArray的操作下标，j为rightArray的操作下标，k为newArray的操作下标
        while (i < leftArray.length && j < rightArray.length){
            newArray[k++] = leftArray[i] < rightArray[j] ? leftArray[i++] : rightArray[j++];
        }

        while (i < leftArray.length) newArray[k++] = leftArray[i++];
        while (j < rightArray.length) newArray[k++] = rightArray[j++];

        return newArray;
    }

    public static void main(String[] args) {
        int[] nums = SortHelper.generateRandomArray(20,100);
        System.out.println("归并排序");
        System.out.println("排序之前：");
        for (int i : nums) System.out.print(i + ",");
        nums = new MergeSort().mergeSort(nums,0,nums.length-1);
        System.out.println("\n排序之后：");
        for (int i : nums) System.out.print(i + ",");
    }
}
