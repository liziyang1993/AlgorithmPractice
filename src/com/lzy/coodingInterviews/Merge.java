package com.lzy.coodingInterviews;

public class Merge {

    public ListNode Merge(ListNode list1,ListNode list2) {

        if (list1 == null && list2 == null) return null;
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        ListNode node ;
        if (list1.val < list2.val){
            node = new ListNode(list1.val);
            list1 = list1.next;
        } else{
            node = new ListNode(list2.val);
            list2 = list2.next;
        }
        ListNode head = node;

        while (list1 != null && list2 != null){
            if (list1.val < list2.val){
                node.next = new ListNode(list1.val);
                node = node.next;
                list1 = list1.next;
            } else {
                node.next = new ListNode(list2.val);
                node = node.next;
                list2 = list2.next;
            }
        }

        if (list1 != null){
            node.next = list1;
        }
        else if (list2 != null){
            node.next = list2;
        }
        return head;
    }
}
