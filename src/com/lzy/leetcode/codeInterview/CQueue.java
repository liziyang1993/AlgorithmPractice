package com.lzy.leetcode.codeInterview;

import java.util.Stack;
/**
 * LeetCode 《剑指offer》 面试题09. 用两个栈实现队列
 * 解题思路：当第二个栈为空时，将第一个栈的数据依次取出，压入第二个栈中。
 * */
public class CQueue {

    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public CQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if (stack2.size() == 0){
            if (stack1.size() == 0) return -1;
            while (!stack1.empty()) stack2.push(stack1.pop());
        }
        return stack2.pop();
    }
}
