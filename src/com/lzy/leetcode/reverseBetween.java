package com.lzy.leetcode;

import java.util.Stack;
/**
 * LeetCode  反转链表 II  题目编号：92
 * 局部反转链表，借助栈来实现链表的反转，注意前后关系的衔接
 * */
public class reverseBetween {
    public static void main(String[] args){
        ListNode listNode = new ListNode(3);
        listNode.next = new ListNode(5);
        ListNode ans = new reverseBetween().reverseBetween(listNode,1,2);
        while (ans != null){
            System.out.println(ans.val);
            ans = ans.next;
        }
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) return null;
        ListNode ans = head;
        Stack<ListNode> stack = new Stack<>();
        ListNode start=null,end=null;
        int i = 1;
        while (head != null){
            if (i == m-1) start = head;
            if (i == n+1) end = head;
            if (i >= m && i <= n ) stack.push(head);
            head = head.next;
            i++;
        }
        if (start == null) {
            start = stack.pop();
            ans = start;//重点：如果从头部开始反转，则需要重新保存头结点的引用
        }
        while (! stack.isEmpty()){
            start.next = stack.pop();
            start = start.next;
        }
        start.next = end;

        return ans;
    }
}
