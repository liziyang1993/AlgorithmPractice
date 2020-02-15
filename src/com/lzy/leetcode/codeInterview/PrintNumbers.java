package com.lzy.leetcode.codeInterview;

public class PrintNumbers {
    public int[] printNumbers(int n) {
        int range = 1;
        for (int i = 1; i<=n;i++){
            range *=10;
        }
        range--;
        int[] res = new int[range];
        for (int i = 1;i <= range;i++){
            res[i-1] = i;
        }
        return  res;
    }
    public static void main(String[] args) {
        int[] res = new PrintNumbers().printNumbers(2);
        for(int i : res){
            System.out.print(i+",");
        }
    }

}
