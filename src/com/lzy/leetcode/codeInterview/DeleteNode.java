package com.lzy.leetcode.codeInterview;
/**
 * LeetCode上《剑指offer》 面试题18. 删除链表的节点
 * 核心思想：在链表中找到待删除的节点，用下一个节点覆盖当前节点
 * */
public class DeleteNode {
    public ListNode deleteNode(ListNode head, int val) {

        if (head == null) return null;
        if (head.val == val) return head.next;
        ListNode node = head;
        while (node != null) {
            if (node.next.val == val) {
                node.next = node.next.next;
                return head;
            }
            node = node.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode node = listNode;
        for (int i = 2; i <= 10; i++) {
            listNode.next = new ListNode(i);
            listNode = listNode.next;
        }
        ListNode result = new DeleteNode().deleteNode(node, 5);
        System.out.println();
    }
}
