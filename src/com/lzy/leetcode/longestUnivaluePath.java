package com.lzy.leetcode;

public class longestUnivaluePath {
    public static void main(String[] args){

    }

    public int longestUnivaluePath(TreeNode root) {

        if (root == null) return 0;
        int left = root.val == getValue(root.left)? longestUnivaluePath(root.left) + 1 : longestUnivaluePath(root.left);
        int right = root.val == getValue(root.right) ? longestUnivaluePath(root.right) + 1 : longestUnivaluePath(root.right);
        if (getValue(root.left) == root.val && getValue(root.right) == root.val) return  left + right;
        return Math.max(left,right);
    }

    public int getValue(TreeNode root){
        if(root == null) return Integer.MAX_VALUE;
        return root.val;
    }

}
