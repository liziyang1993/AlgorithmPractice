package com.lzy.leetcode.codeInterview;
/**
 * 剑指offer 面试题27. 二叉树的镜像
 * */
public class MirrorTree {

    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return root;
        TreeNode temp = mirrorTree(root.left);
        root.left = mirrorTree(root.right);
        root.right = temp;
        return root;
    }
}
