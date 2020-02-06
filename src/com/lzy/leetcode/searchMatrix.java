package com.lzy.leetcode;

/**
 * LeetCode：搜索二维矩阵 题目编号：74
 * 解题技巧：从矩阵的右上角或左下角开始搜索，每次比较可以排除一行或一列的数据
 * 不断缩小范围，最后锁定目标值
 * */
public class searchMatrix {
    public static void main(String[] args){
        int[][] matrix = {
                {1,   3,  5,  7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };
        System.out.println(new searchMatrix().searchMatrix(matrix,6));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length <=0)return  false;
        int i = 0, j = matrix[0].length-1;
        while (i < matrix.length && j >= 0){
            if (matrix[i][j] == target) return true;
            if (matrix[i][j] > target) j--;
            else if (matrix[i][j] < target) i++;
        }
        return false;
    }
}
