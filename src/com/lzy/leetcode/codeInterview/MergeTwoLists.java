package com.lzy.leetcode.codeInterview;
/**
 * 剑指offer  面试题25. 合并两个排序的链表
 * */
public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode node;
        if (l1.val < l2 .val){
            node = l1;
            l1 = l1.next;
        }else {
            node = l2;
            l2 = l2.next;
        }
        ListNode head = node;
        while (l1 != null && l2 != null){
            if (l1.val < l2 .val){
                node.next = l1;
                l1 = l1.next;
            }else {
                node.next = l2;
                l2 = l2.next;
            }
            node = node.next;
        }
        if (l1 != null) node.next = l1;
        if (l2 != null) node.next = l2;

        return head;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode node1 = listNode1;
        for (int i = 2; i <= 10; i++) {
            listNode1.next = new ListNode(i);
            listNode1 = listNode1.next;
        }
        ListNode listNode2 = new ListNode(1);
        ListNode node2 = listNode2;
        for (int i = 2; i <= 10; i++) {
            listNode2.next = new ListNode(i);
            listNode2 = listNode2.next;
        }
        ListNode result = new MergeTwoLists().mergeTwoLists(node1,node2);
        System.out.println();
    }
}
