package com.lzy.leetcode.codeInterview;
/**
 * LeetCode上《剑指offer》 面试题24. 反转链表
 * 核心思想：分别可以用栈或递归两种方式实现
 * */
public class ReverseList {
    private ListNode listNode;

    public ListNode reverseList(ListNode head) {

        if (head == null || head.next == null) return head;

        ListNode node = reverseList(head.next);
        head.next.next = head;
        head.next = null;

        return node;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode node = listNode;
        for (int i = 2; i <= 10; i++) {
            listNode.next = new ListNode(i);
            listNode = listNode.next;
        }
        ListNode result = new ReverseList().reverseList(node);
        System.out.println();
    }
}
