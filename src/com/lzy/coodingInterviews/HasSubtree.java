package com.lzy.coodingInterviews;
/**
 * 剑指offer 面试题26 树的子结构
 * 递归的解法，先找到与子树根的值相等的节点，在判断两个子树是否相同
 * 注意：递归的过程中一定要小心判断空指针的问题
 * */
public class HasSubtree {

    public boolean HasSubtree(TreeNode root1,TreeNode root2) {

        if (root1 == null || root2 == null) return false;

        boolean result = false;

        if (root1.val == root2.val) result = DoesTree1HaveTree2(root1,root2);
        if (!result) result = HasSubtree(root1.left,root2);
        if (!result) result = HasSubtree(root1.right,root2);

        return result;
    }

    private boolean DoesTree1HaveTree2(TreeNode root1,TreeNode root2){

        if (root2 == null) return true;
        if (root1 == null) return false;
        if (root1.val != root2.val) return false;

        return DoesTree1HaveTree2(root1.left,root2.left)&&DoesTree1HaveTree2(root1.right,root2.right);
    }
}
