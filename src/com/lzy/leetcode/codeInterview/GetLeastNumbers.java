package com.lzy.leetcode.codeInterview;

import java.util.Comparator;
import java.util.PriorityQueue;

public class GetLeastNumbers {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k <= 0) return new int[0];
        int[] result = new int[k];
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, Comparator.reverseOrder());
        for (int i = 0; i < k; i++) queue.add(arr[i]);
        for (int i = k; i < arr.length; i++) {
            if (arr[i] < queue.peek()) {
                queue.poll();
                queue.add(arr[i]);
            }
        }
        for (int i = 0; i < k; i++) result[i] = queue.poll();
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 9, 8, 4, 5, 6, 3};
        int[] result = new GetLeastNumbers().getLeastNumbers(arr, 4);
        System.out.println();
    }
}
