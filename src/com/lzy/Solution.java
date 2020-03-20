package com.lzy;

import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {

    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr.length == 0 || arr.length < k || k <= 0) return new int[0];
        int[] result = new int[k];
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
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
        int[] nums = {1, 2, 3, 4, 4, 3, 2, 1};
        int[] result = new Solution().getLeastNumbers(nums, 4);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}