package com.lzy.leetcode;

/**
 * LeetCode 从前序与中序遍历序列构造二叉树  题目编号： 105
 * 核心思想：深刻理解先序遍历和中序遍历的流程，使用递归的方法构造二叉树，注意数组的划分处理
 * */
public class BuildTree {


    public static void main(String[] args){
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        TreeNode root = new BuildTree().buildTree(preorder,inorder);
        System.out.println(root);

    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length==0 || preorder.length != inorder.length) return null;
        int rootValue = preorder[0];
        TreeNode rootNode = new TreeNode(rootValue);
        if (preorder.length <= 1)
            return rootNode;
        int rootLocation = 0;
        for (int i = 0; i < inorder.length; i++){
            if (inorder[i] == rootValue){
                rootLocation = i;
                break;
            }
        }
        int[] leftInorder = subSequent(inorder,0,rootLocation-1);
        int[] rightInorder = subSequent(inorder,rootLocation+1,inorder.length-1);
        int[] leftPreoder = getPreOrder(preorder,leftInorder);
        int[] rightPreorder = getPreOrder(preorder,rightInorder);
        rootNode.left = buildTree(leftPreoder,leftInorder);
        rootNode.right = buildTree(rightPreorder,rightInorder);

        return rootNode;

    }


    private int[] subSequent(int[] nums, int min, int max){
        int[] result = new int[max-min+1];
        for (int i = min,j = 0; i <= max; i++,j++){
            result[j] = nums[i];
        }
        return result;
    }

    private int[] getPreOrder(int[] nums, int[] inorder){
        int[] result = new int[inorder.length];
        int location = 0;
        for(int i = 0; i< nums.length; i++){
            for (int j = 0; j < inorder.length;j++){
                if (nums[i] == inorder[j]){
                    location = i;
                    break;
                }
            }
            if (location > 0 ) break;
        }
        for (int i = location,j=0; j < inorder.length;i++,j++ ){
            result[j] = nums[i];
        }
        return result;

    }






}
