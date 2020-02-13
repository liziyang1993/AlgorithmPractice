package com.lzy.leetcode.codeInterview;

import java.util.Stack;

/**
 * LeetCode 《剑指offer》  面试题06. 从尾到头打印链表
 * 递归解法
 * */

public class ReversePrint {

    private int[] result;

    public int[] reversePrint(ListNode head) {

        reverse(head,0);

        return result;
    }

    private int reverse(ListNode head,int length){

        if (head == null){
            result = new int[length];
            return 0;
        }
        length = reverse(head.next,length+1);
        result[length++] = head.val;
        return length;

    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode node = listNode;
        for (int i = 2; i <= 10; i++) {
            listNode.next = new ListNode(i);
            listNode = listNode.next;
        }
        int[] result = new ReversePrint().reversePrint(node);
        System.out.println();
    }
}
