package com.lzy.sort;
/**
 * 希尔排序
 * 希尔排序是插入排序的改进版，通过对所有数据进行分组的插入排序，在初始阶段使整个数组大致有序
 * 有效减少了数组中元素比较和交换的次数
 * */
public class ShellSort {

    public int[] shellSort(int[] nums){

        for (int gap = nums.length/2; gap > 0; gap /= 2){
            for (int i = 0; i < gap; i++)        //直接插入排序
            {
                for (int j = i + gap; j < nums.length; j += gap)
                    if (nums[j] < nums[j - gap])
                    {
                        int temp = nums[j];
                        int k = j - gap;
                        while (k >= 0 && nums[k] > temp)
                        {
                            nums[k + gap] = nums[k];
                            k -= gap;
                        }
                        nums[k + gap] = temp;
                    }
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = SortHelper.generateRandomArray(20,100);
        System.out.println("希尔排序");
        System.out.println("排序之前：");
        for (int i : nums) System.out.print(i + ",");
        nums = new ShellSort().shellSort(nums);
        System.out.println("\n排序之后：");
        for (int i : nums) System.out.print(i + ",");
    }
}
