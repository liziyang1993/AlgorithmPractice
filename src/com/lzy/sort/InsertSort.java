package com.lzy.sort;

public class InsertSort {

    public int[] insertSort(int[] nums){

        if (nums == null || nums.length == 0) return null;

        for (int i = 1; i < nums.length; i++){
            int temp = nums[i];
            int j = i-1;
            for (; j >= 0; j--){
                if (temp < nums[j]) nums[j+1] = nums[j];
                else {
                    break;
                }
            }
            nums[j+1] = temp;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = SortHelper.generateRandomArray(10,100);
        System.out.println("插入排序");
        System.out.println("排序之前：");
        for (int i : nums) System.out.print(i + ",");
        nums = new InsertSort().insertSort(nums);
        System.out.println("\n排序之后：");
        for (int i : nums) System.out.print(i + ",");
    }
}
