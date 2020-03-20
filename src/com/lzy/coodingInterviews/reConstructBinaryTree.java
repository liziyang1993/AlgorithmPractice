package com.lzy.coodingInterviews;

import java.util.Scanner;

/**
 * 剑指offer 面试题7 重建二叉树
 */
public class reConstructBinaryTree {

    public static void main(String[] args) {


    }

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre.length == 0 || pre.length != in.length) return null;
        int rootValue = pre[0];
        TreeNode rootNode = new TreeNode(rootValue);
        if (pre.length <= 1)
            return rootNode;
        int rootLocation = 0;
        for (int i = 0; i < in.length; i++) {
            if (in[i] == rootValue) {
                rootLocation = i;
                break;
            }
        }
        int[] leftInorder = subSequent(in, 0, rootLocation - 1);
        int[] rightInorder = subSequent(in, rootLocation + 1, in.length - 1);
        int[] leftPreoder = getPreOrder(pre, leftInorder);
        int[] rightPreorder = getPreOrder(pre, rightInorder);
        rootNode.left = reConstructBinaryTree(leftPreoder, leftInorder);
        rootNode.right = reConstructBinaryTree(rightPreorder, rightInorder);

        return rootNode;
    }

    private int[] subSequent(int[] nums, int min, int max) {
        int[] result = new int[max - min + 1];
        for (int i = min, j = 0; i <= max; i++, j++) {
            result[j] = nums[i];
        }
        return result;
    }

    private int[] getPreOrder(int[] nums, int[] inorder) {
        int[] result = new int[inorder.length];
        int location = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < inorder.length; j++) {
                if (nums[i] == inorder[j]) {
                    location = i;
                    break;
                }
            }
            if (location > 0) break;
        }
        for (int i = location, j = 0; j < inorder.length; i++, j++) {
            result[j] = nums[i];
        }
        return result;

    }
}
