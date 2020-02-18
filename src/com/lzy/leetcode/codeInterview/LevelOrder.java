package com.lzy.leetcode.codeInterview;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class LevelOrder {
    public int[] levelOrder(TreeNode root) {
        if (root == null) return new int[0];
        ArrayList<Integer> list = new ArrayList<>();
        ArrayDeque<TreeNode> que = new ArrayDeque<>();
        que.add(root);
        list.add(root.val);
        while (!que.isEmpty()){
            TreeNode node = que.pollFirst();
            if (node.left != null) {
                list.add(node.left.val);
                que.add(node.left);
            }
            if (node.right != null){
                list.add(node.right.val);
                que.add(node.right);
            }

        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) result[i] = list.get(i);
        return result;
    }
}
