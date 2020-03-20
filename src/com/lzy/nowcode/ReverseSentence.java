package com.lzy.nowcode;

import java.util.Stack;

public class ReverseSentence {
    public String ReverseSentence(String str) {
        if (str==null || str.length()==0) return str;
        StringBuilder builder = new StringBuilder("");
        String[] data = str.split(" ");
        Stack<String> stack = new Stack<>();
        for(String s : data) stack.push(s);
        while (stack.size()>1){
            builder.append(stack.pop()+" ");
        }
        builder.append(stack.pop());
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new ReverseSentence().ReverseSentence(""));
    }
}
