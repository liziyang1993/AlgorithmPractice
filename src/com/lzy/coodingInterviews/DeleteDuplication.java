package com.lzy.coodingInterviews;
/**
 * 剑指offer 面试题18 题目二  删除链表中重复的节点
 * 当需要删除链表中当前节点时，将下一个节点的值复制至当前节点，然后将下一个节点删去。
 * 注意空指针的处理
 * 特别注意：需要删除链表的头节点和尾节点时，需要单独处理。
 * */
public class DeleteDuplication {
    public ListNode deleteDuplication(ListNode pHead)
    {
        ListNode result = pHead;
        while (pHead != null && pHead.next != null){
            boolean isDuplicate = false;
            while (pHead.next != null && pHead.val == pHead.next.val){
                pHead.next = pHead.next.next;
                isDuplicate = true;
            }
            if (isDuplicate){
                if (pHead.next !=null){
                    pHead.val = pHead.next.val;
                    pHead.next = pHead.next.next;
                }else {
                    int val = pHead.val;
                    if (result.val == val){
                        result = null;
                        break;
                    }
                    pHead = result;
                    while (pHead != null){
                        if (pHead.next.val == val) pHead.next = null;
                        pHead = pHead.next;
                    }
                }

            } else pHead = pHead.next;
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode node = listNode;
        for (int i = 2; i <= 5; i++) {
            listNode.next = new ListNode(1);
            listNode = listNode.next;
        }
        ListNode result = new DeleteDuplication().deleteDuplication(node);
        while (result != null){
            System.out.println(result.val);
            result = result.next;
        }
    }
}
