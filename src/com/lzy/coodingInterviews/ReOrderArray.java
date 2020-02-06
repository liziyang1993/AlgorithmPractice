package com.lzy.coodingInterviews;
/**
 * 剑指offer 面试题21 调整数组顺序使奇数位于偶数前面
 * 目前的解法能满足书上的要求，所有的奇数位于数组的前半部分，偶数位于后半部分。
 * 但牛客网的OJ要求：奇数和奇数的相对位置，偶数和偶数的相对位置保持不变，这一点尚未实现
 * 要是后半部分偶数的相对位置有所变化。
 * */
public class ReOrderArray {

    private boolean isEven(int n) {return n % 2 == 0;}

    public void reOrderArray(int [] array) {
        for (int i = 0; i < array.length; i++){
            if (isEven(array[i])){
                int temp = array[i];
                for (int j = i; j < array.length-1; j++){
                    array[j] = array[j+1];
                }
                array[array.length-1] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,9};
        new ReOrderArray().reOrderArray(nums);
        for (int i : nums) System.out.print(i+",");
    }
}
