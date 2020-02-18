package com.lzy.leetcode.codeInterview;

/**
 * 剑指offer  面试题26. 树的子结构
 */
public class IsSubStructure {
    public boolean isSubStructure(TreeNode A, TreeNode B) {

        if (A == null || B == null) return false;

        boolean flag = false;
        if (A.val == B.val) flag = hasSubStructure(A, B);
        if (!flag) flag = isSubStructure(A.right, B);
        if (!flag) flag = isSubStructure(A.left, B);

        return flag;
    }

    private boolean hasSubStructure(TreeNode A, TreeNode B) {

        if (B == null) return true;
        if (A == null) return false;
        if (A.val != B.val) return false;
        return hasSubStructure(A.left, B.left) && hasSubStructure(A.right, B.right);
    }

}
