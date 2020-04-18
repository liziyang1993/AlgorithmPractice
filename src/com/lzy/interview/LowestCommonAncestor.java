package com.lzy.interview;

/**
 * 最低公共子节点，递归解法，通过递归寻找两个节点的最低公共祖先。
 */
public class LowestCommonAncestor {


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == root || q == root) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }

        return left == null ? right : left;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode right = new TreeNode(2);
        root.right = right;
        TreeNode left = new TreeNode(3);
        root.left = left;
        TreeNode commenNode = new LowestCommonAncestor().lowestCommonAncestor(root, left, right);
        System.out.println("最低公共子节点为：" + commenNode.val);

    }

}

/**
 * 二叉树的节点封装
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}