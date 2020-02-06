package com.lzy.coodingInterviews;
/**
 * 剑指offer 面试题27 二叉树的镜像
 * 使用递归的解法依次交换每个节点的两棵子树，注意考虑空节点情况的处理
 * */
public class Mirror {
    public void Mirror(TreeNode root) {
        if (root == null) return;
        root = getMirror(root);
    }

    private TreeNode getMirror(TreeNode root){
        if (root == null) return null;
        TreeNode right = root.right;
        root.right = getMirror(root.left);
        root.left = getMirror(right);
        return root;
    }
}
