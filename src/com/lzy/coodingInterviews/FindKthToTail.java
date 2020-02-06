package com.lzy.coodingInterviews;

public class FindKthToTail {

    public ListNode FindKthToTail(ListNode head,int k) {

        if (head == null || k <= 0) return null;

        ListNode p = head;
        for (int i = 1; i <= k; i++) {
            p = p.next;
            if (p == null && i < k) return null;
        }
        while (p != null){
            head = head.next;
            p = p.next;
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
        ListNode result = new FindKthToTail().FindKthToTail(node,10);
        System.out.println(result.val);
    }
}
