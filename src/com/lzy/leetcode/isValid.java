package com.lzy.leetcode;

import java.util.Stack;

public class isValid {

    public static void main(String[] args){
        System.out.println(new isValid().isValid("([)]"));
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()){
            if (c == '(' || c == '[' || c == '{') stack.push(c);
            else{
                if (stack.isEmpty())return false;
                char c1 = stack.pop();
                if (c == ')' && c != c1+1) return false;
                if (c > 50 && c != c1+2) return false;
            }
        }
        if (stack.isEmpty())return true;
        else return false;
    }
}
