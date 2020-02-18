package com.lzy.leetcode.codeInterview;

import java.util.Stack;

/**
 * 剑指offer  面试题31. 栈的压入、弹出序列
 */
public class ValidateStackSequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {

        if (pushed.length != popped.length) return false;
        if (pushed.length == 0) return true;

        Stack<Integer> stack = new Stack<>();
        int i = 0;
        stack.push(pushed[i++]);
        for (int x : popped) {
            while (stack.empty() || stack.peek() != x) {
                if (i >= pushed.length) return false;
                stack.push(pushed[i++]);
            }
            stack.pop();
        }
        if (i == pushed.length && stack.empty()) return true;
        return false;
    }

    public static void main(String[] args) {
        int[] pushed = {1, 2, 3, 4, 5}, popped = {4, 3, 5, 1, 2};
        System.out.println(new ValidateStackSequences().validateStackSequences(pushed, popped));
    }
}
