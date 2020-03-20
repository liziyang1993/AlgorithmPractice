package com.lzy.nowcode;

import java.util.ArrayList;

public class FindContinuousSequence {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int left = 1, right = 2;
        while (left < right && right < sum) {
            int s = (left + right) * (right - left + 1) / 2;
            if (s == sum) {
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = left; i <= right; i++) list.add(i);
                result.add(list);
                right++;
            } else if (s < sum) {
                right++;
            } else {
                left++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        new FindContinuousSequence().FindContinuousSequence(100);
    }
}
