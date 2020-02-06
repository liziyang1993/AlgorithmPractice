package com.lzy.leetcode;

import java.util.Stack;
/**
 * LeetCode
 * */
public class reverseList_stack {
    public static void main(String[] args){
        ListNode listNode = new ListNode(1);
        ListNode node = listNode;
        for (int i =2;i<=5;i++){
            listNode.next = new ListNode(i);
            listNode = listNode.next;
        }
        ListNode ans = new reverseList_stack().reverseList(node);
        while (ans != null){
            System.out.println(ans.val);
            ans = ans.next;
        }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        Stack<ListNode> stack = new Stack<>();
        while (head != null){
            stack.push(head);
            head = head.next;
        }
        ListNode list = stack.pop();
        ListNode ans = list;
        while (!stack.isEmpty()){
            list.next = stack.pop();
            list = list.next;
        }
        list.next = null;
        return ans;
    }
}
