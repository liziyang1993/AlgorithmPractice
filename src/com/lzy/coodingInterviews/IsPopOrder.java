package com.lzy.coodingInterviews;

import java.util.Stack;
/**
 * 剑指offer 面试题31  栈的压入、弹出序列
 * 结题思路：建立一个栈，并模拟栈的压入、弹出过程即可。
 * */
public class IsPopOrder {

    public boolean IsPopOrder(int [] pushA,int [] popA) {

        Stack<Integer> stack = new Stack<>();
        int i = 0, j = 0;
        stack.push(pushA[i++]);
        while (j < popA.length){
            if (stack.peek() == popA[j]){
                stack.pop();
                j++;
            }else if (i < pushA.length){
                stack.push(pushA[i++]);
            }else return false;
        }
        return true;
    }
    public static void main(String[] args) {
        int[] pushA = {1,2,3,4,5};
        int[] popA = {4,3,5,1,2};
        System.out.println(new IsPopOrder().IsPopOrder(pushA,popA));
    }
}
