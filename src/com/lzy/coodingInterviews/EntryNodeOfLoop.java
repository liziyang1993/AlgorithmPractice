package com.lzy.coodingInterviews;
/**
 * 剑指offer 面试题23  链表中环的入口结点
 * 解题思路分以下三步：
 * 1.判断链表中是否存在环，并将两个指针p1,p2置于环中
 * 2.统计环中节点的数目
 * 3.两个指针从链表的头节点开始，找到环的入口节点。
 * */
public class EntryNodeOfLoop {

    public ListNode EntryNodeOfLoop(ListNode pHead) {

        ListNode p1 = pHead, p2 = pHead;

        while (p1 != null && p2 != null){
            p1 = p1.next;
            p2 = p2.next;
            if (p2 == null || p2.next == null) return null;
            p2 = p2.next;
            if (p1 == p2) break;
        }
        int k = 0, val = p1.val;
        while (p1.next != null){
            p1 = p1.next;
            k++;
            if (p1.val == val) break;
        }
        p1 = pHead; p2 = pHead;
        for (int i = 1; i <= k; i++){
            p1 = p1.next;
        }
        while (p1 != p2) {
            p1 = p1 .next;
            p2 = p2.next;
        }
        return p1;
    }
}
