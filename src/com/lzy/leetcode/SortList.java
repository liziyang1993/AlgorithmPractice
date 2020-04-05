package com.lzy.leetcode;

public class SortList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode result = new ListNode(-1);
        result.next = head;
        ListNode pre = head, cur = head.next;
        while (cur != null) {
            if (cur.val < pre.val) {
                pre.next = cur.next;
                ListNode l1 = result, l2 = result.next;
                while (cur.val > l2.val) {
                    l1 = l2;
                    l2 = l2.next;
                }
                l1.next = cur;
                cur.next = l2;
                cur = pre.next;
            } else {
                pre = cur;
                cur = cur.next;
            }
        }
        return result.next;
    }
}
