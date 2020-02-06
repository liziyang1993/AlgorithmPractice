package com.lzy.coodingInterviews;

import java.util.ArrayList;
import java.util.Stack;


/**
 * 剑指offer 面试题6  从尾到头打印链表
 * 迭代解法，用一个栈辅助实现
 */

public class PrintListFromTailToHead_iteration {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode node = listNode;
        for (int i = 2; i <= 5; i++) {
            listNode.next = new ListNode(i);
            listNode = listNode.next;
        }
        ArrayList<Integer> list = new PrintListFromTailToHead_iteration().printListFromTailToHead(node);
        for (Integer i : list) {
            System.out.println(i);
        }
    }

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        ArrayList<Integer> list = new ArrayList<>();
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
        return list;
    }
}
