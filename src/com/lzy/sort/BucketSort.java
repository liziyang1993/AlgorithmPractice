package com.lzy.sort;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 排序算法 - 桶排序
 * */
public class BucketSort {

    public int[] bucketSort(int[] arr){

        // 计算最大值与最小值
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length; i++){
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }

        // 计算桶的数量
        int bucketNum = (max - min) / arr.length + 1;
        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketNum);
        for(int i = 0; i < bucketNum; i++){
            bucketArr.add(new ArrayList<Integer>());
        }

        // 将每个元素放入桶
        for(int i = 0; i < arr.length; i++){
            int num = (arr[i] - min) / (arr.length);
            bucketArr.get(num).add(arr[i]);
        }

        // 对每个桶进行排序
        for(int i = 0; i < bucketArr.size(); i++){
            Collections.sort(bucketArr.get(i));
        }

        // 将桶中的元素赋值到原序列
        int index = 0;
        for(int i = 0; i < bucketArr.size(); i++){
            for(int j = 0; j < bucketArr.get(i).size(); j++){
                arr[index++] = bucketArr.get(i).get(j);
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] nums = SortHelper.generateRandomArray(20,100);
        System.out.println("桶排序");
        System.out.println("排序之前：");
        for (int i : nums) System.out.print(i + ",");
        nums = new BucketSort().bucketSort(nums);
        System.out.println("\n排序之后：");
        for (int i : nums) System.out.print(i + ",");
    }

}
