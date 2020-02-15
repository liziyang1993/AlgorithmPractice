package com.lzy.coodingInterviews;
/**
 * 剑指offer 面试题14  剪绳子
 * 动态规划解法，需要注意输入数据为3或3以下的数据需要特殊处理。
 * */
public class CutRope {

    public int cutRope(int target) {

        if (target < 2)return 0;
        if (target == 2)return 1;
        if (target == 3)return 2;

        int[] k = new int[target>=4?target+1:4];
        k[0] = 0;
        k[1] = 1;
        k[2] = 2;
        k[3] = 3;

        for (int i = 4; i <= target; i++){
            int max = 0;
            for (int j = 1; j < i; j++){
                max = k[j]*k[i-j]>max ? k[j]*k[i-j] : max;
            }
            k[i] = max;
        }

        return k[target];
    }

    public static void main(String[] args) {
        System.out.println(new CutRope().cutRope(8));
    }
}
