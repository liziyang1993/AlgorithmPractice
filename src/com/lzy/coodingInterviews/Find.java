package com.lzy.coodingInterviews;

/**
 * 剑指offer  面试题4  二维数组中的查找
 * 解题思路：这道题的关键是从矩阵的右上角或者左下角开始查找
 * 当array[i][j] > target时，向左移动一列进行查找
 * 当array[i][j] < target时，向下移动一行进行查找
 */
public class Find {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };

        System.out.println(new Find().Find(6, matrix));
    }

    public boolean Find(int target, int[][] array) {
        int i = 0, j = array[0].length - 1;
        while (i < array.length && j >= 0) {
            if (array[i][j] == target) return true;
            if (array[i][j] > target) j--;
            else if (array[i][j] < target) i++;
        }
        return false;
    }
}
