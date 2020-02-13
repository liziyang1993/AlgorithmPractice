package com.lzy.leetcode.codeInterview;

/**
 * LeetCode中《剑指offer》 面试题04：二维数组中的查找。
 * */

public class FindNumberIn2DArray {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {

        if (matrix.length <= 0) return false;

        int i = 0, j = matrix[0].length-1;

        while (i < matrix.length && j >= 0){
            if (target == matrix[i][j] ) return true;
            else if (target > matrix[i][j]) i++;
            else if (target < matrix[i][j]) j--;
        }
        return false;
    }

    public static void main(String[] args){

        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        System.out.println(new FindNumberIn2DArray().findNumberIn2DArray(matrix,18));

    }
}
