package com.lzy.leetcode;
/**
 *
 * */
public class mergeTwoLists {
    public static void main(String[] args){
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode node ;
        if (l1.val < l2.val){
            node = new ListNode(l1.val);
            l1 = l1.next;
        } else{
            node = new ListNode(l2.val);
            l2 = l2.next;
        }
        ListNode head = node;

        while (l1 != null && l2 != null){
            if (l1.val < l2.val){
                node.next = new ListNode(l1.val);
                node = node.next;
                l1 = l1.next;
            } else {
                node.next = new ListNode(l2.val);
                node = node.next;
                l2 = l2.next;
            }
        }

        if (l1 != null){
            node.next = l1;
        }
        else if (l2 != null){
            node.next = l2;
        }
        return head;
    }
}
