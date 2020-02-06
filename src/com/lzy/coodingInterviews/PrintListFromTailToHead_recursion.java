package com.lzy.coodingInterviews;

import java.util.ArrayList;

/**
 * 剑指offer 面试题6  从尾到头打印链表
 * 递归解法
 */

public class PrintListFromTailToHead_recursion {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode node = listNode;
        for (int i = 2; i <= 5; i++) {
            listNode.next = new ListNode(i);
            listNode = listNode.next;
        }
        ArrayList<Integer> list = new PrintListFromTailToHead_recursion().printListFromTailToHead(node);
        for (Integer i : list) {
            System.out.println(i);
        }
    }

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode == null) return new ArrayList<Integer>();
        ArrayList<Integer> list = printListFromTailToHead(listNode.next);
        list.add(listNode.val);
        return list;
    }
}
