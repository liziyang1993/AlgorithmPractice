package com.lzy.nowcode;

public class cakeNumber {
    public String calculate (int n) {
        // write code here
        long count = 0;
        for (int i = 1;i<=n;i++){
            if(!String.valueOf(i).contains("66")){
                count++;
            }
        }
        return String.valueOf(count);
    }

    public static void main(String[] args) {
        System.out.println(new cakeNumber().calculate(100));
    }
}
