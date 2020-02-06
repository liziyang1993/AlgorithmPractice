package com.lzy.leetcode;

public class reverseList {
    public static void main(String[] args){
        ListNode listNode = new ListNode(1);
        ListNode node = listNode;
        for (int i =2;i<=5;i++){
            listNode.next = new ListNode(i);
            listNode = listNode.next;
        }
        ListNode ans = new reverseList().reverseList(node);
        while (ans != null){
            System.out.println(ans.val);
            ans = ans.next;
        }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}


