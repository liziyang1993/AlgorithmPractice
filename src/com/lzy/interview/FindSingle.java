package com.lzy.interview;

public class FindSingle {

    public char findSingle(String value) {
        int left = 0, right = value.length() - 1;
        while (left < right) {
            int midle = left + (right - left) / 2;
            if (value.charAt(midle) == value.charAt(midle + 1)) midle++;
            if ((midle - left + 1) % 2 == 0) left = midle+1 ;
            else right = midle-1 ;
        }
        return value.charAt(left);
    }

    public static void main(String[] args) {
        String str = "aabbrcceeddqqffgg";
        System.out.println(new FindSingle().findSingle(str));
    }
}
