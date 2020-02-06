package com.lzy.coodingInterviews;

/**
 * 剑指offer 面试题5  替换空格
 * 作弊解法，直接用java原生api实现
 */
public class ReplaceSpace {

    public static void main(String[] args) {

        System.out.println(new ReplaceSpace().replaceSpace(new StringBuffer("We Are Happy.")));
    }

    public String replaceSpace(StringBuffer str) {

        return str.toString().replaceAll(" ", "%20");
    }
}
