package com.lzy.nowcode;
/**
 * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，
 * 就是用字符串模拟这个指令的运算结果。对于一个给定的字符序列S，
 * 请你把其循环左移K位后的序列输出。例如，字符序列S=”abcXYZdef”,
 * 要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
 * */
public class LeftRotateString {
    public String LeftRotateString(String str,int n) {
        if(str == null || str.length() == 0 || str.length()<n)return str;
        char[] array = str.toCharArray();
        reverse(array,0,array.length-1);
        reverse(array,array.length-n,array.length-1);
        reverse(array,0,array.length-n-1);
        return String.valueOf(array);
    }

    public void reverse(char[] array,int left,int right){
        while (left<right){
            char temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args){
        System.out.println(new LeftRotateString().LeftRotateString("abcXYZdef",3));
    }

}
