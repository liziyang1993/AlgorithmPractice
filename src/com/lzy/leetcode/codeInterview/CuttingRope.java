package com.lzy.leetcode.codeInterview;

public class CuttingRope {

    public int cuttingRope(int n) {

        if (n <= 1) return n;
        if (n <= 3) return n-1;
        int[] k = new int[n + 1];
        for (int i = 0; i <= 3; i++) k[i] = i;

        for (int i = 4; i <= n; i++) {
            int max = 0;
            for (int j = 1; j < i; j++)
                max = k[i - j] * k[j] > max ? k[i - j] * k[j] : max;
            k[i] = max;
        }

        return k[n];
    }

    public static void main(String[] args) {
        System.out.println(new CuttingRope().cuttingRope(8));
    }

}
