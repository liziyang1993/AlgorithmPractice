package com.lzy.leetcode;

/**
 * Leetcode: 两数相加   题目编号： 2
 * 注意：
 * 1. 两个链表可能长度不一样，需要分别进行单独处理。
 * 2. 计算的最后一位，可能还有进位，需要进行判断。
 * */

public class AddTwoNumbers {

    public static void main(String[] args){
        ListNode x = new ListNode(2);
        x.next = new ListNode(4);
        x.next.next = new ListNode(3);
        ListNode y = new ListNode(5);
        y.next= new ListNode(6);
        y.next.next = new ListNode(4);
        y.next.next.next = new ListNode(9);
        ListNode ans = new AddTwoNumbers().addTwoNumbers(x,y);
        System.out.println(ans.val);
        while (ans.next != null){
            ans = ans.next;
            System.out.println(ans.val);
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans ,current;
        int flag = 0;
        if (l1.val+l2.val>=10){
            current = new ListNode((l1.val+l2.val) % 10);
            flag = 1;
        }else {
            current = new ListNode(l1.val+l2.val);
        }
        ans = current;
        while (l1.next!=null && l2.next!=null){
            l1=l1.next;
            l2=l2.next;
            if (l1.val+l2.val+flag>=10){
                current.next = new ListNode((l1.val+l2.val+flag) % 10);
                flag = 1;
            }
            else {
                current.next= new ListNode(l1.val+l2.val+flag);
                flag = 0;
            }
            current = current.next;
        }
        while (l1.next!=null){
            l1 = l1.next;
            if (l1.val+flag>=10){
                current.next = new ListNode((l1.val+flag) % 10);
                flag = 1;
            }
            else {
                current.next= new ListNode(l1.val+flag);
                flag = 0;
            }
            current = current.next;
        }

        while (l2.next != null){
            l2 = l2.next;
            if (l2.val+flag>=10){
                current.next = new ListNode((l2.val+flag) % 10);
                flag = 1;
            }
            else {
                current.next= new ListNode(l2.val+flag);
                flag = 0;
            }
            current = current.next;
        }
        if (flag>0){
            current.next = new ListNode(flag);
        }
        return ans;
    }
}