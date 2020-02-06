package com.lzy.coodingInterviews;

/**
 * 剑指offer 面试题3  数组中的重复数字
 * 解题思路与书中讲的不一样，由于数组中所有数字均在0到n-1，与数组下标的范围一致。
 * 因此通过遍历数组，将下标为a[i]的元素a[a[i]]修改为其相反数，则连续两次被修改的元素下标为重复数
 * 该算法需要修改数组的元素
 */

public class Duplicate {

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 0, 2, 5, 3};
        int[] duplication = new int[1];
        System.out.println(new Duplicate().duplicate(nums, nums.length, duplication));
        System.out.println(duplication[0]);
    }

    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,
    // so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
    public boolean duplicate(int numbers[], int length, int[] duplication) {

        if (numbers == null || numbers.length == 0 || numbers.length != length) return false;

        for (int i : numbers) {
            if (numbers[Math.abs(i)] < 0) {
                duplication[0] = Math.abs(i);
                return true;
            } else {
                numbers[Math.abs(i)] = -numbers[Math.abs(i)];
            }
        }
        duplication[0] = -1;
        return false;
    }

}
