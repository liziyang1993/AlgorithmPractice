package com.lzy.leetcode.codeInterview;

import java.util.ArrayList;

public class MinStack {

    ArrayList<Integer> list;
    int min;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        list = new ArrayList<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int x) {
        if (x < min) min = x;
        list.add(x);
    }

    public void pop() {
        int x = list.remove(list.size() - 1);
        if (x == min) {
            min = Integer.MAX_VALUE;
            for (int i = 0; i < list.size(); i++) {
                min = list.get(i) < min ? list.get(i) : min;
            }
        }
    }

    public int top() {
        return list.get(list.size() - 1);
    }

    public int min() {
        return min;
    }
}
