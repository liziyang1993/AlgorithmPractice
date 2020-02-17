package com.lzy.leetcode.codeInterview;
/**
 * LeetCode中《剑指offer》 面试题22. 链表中倒数第k个节点
 * */
public class GetKthFromEnd {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode node = head;
        for (int i = 1; i < k && node!=null; i++) node= node.next;
        while (node.next != null){
            head=head.next;
            node=node.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode node = listNode;
        for (int i = 2; i <= 6; i++) {
            listNode.next = new ListNode(i);
            listNode = listNode.next;
        }
        ListNode result = new GetKthFromEnd().getKthFromEnd(node,3);
        System.out.println();
    }
}
