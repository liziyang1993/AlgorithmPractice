package com.lzy.coodingInterviews;

/**
 * 剑指offer 面试题8 二叉树的下一个节点
 * 解题思路：
 * 1.如果一个节点有右子树，则下一个节点是右子树的最左子节点
 * 2.如果一个节点没有右子树，但它是其父节点的左子节点，则下一个节点是其父节点
 * 3.如果一个节点没有右子树，它又是父节点的右子节点，则沿着父节点向上遍历，】
 * 直到找到一个节点是其父节点的左子节点，则下一个节点是其父节点
 * 4.除以上情况外，其他情况下均没有下一个节点，应返回null。
 * 特别注意：访问节点是可能出现大量空指针的情况，需要提前考虑和处理所有可能出现的空指针。
 */
public class GetNext {

    public TreeLinkNode GetNext(TreeLinkNode pNode) {

        if (pNode == null) return null;

        if (pNode.right != null) return findleft(pNode.right);

        if (pNode.next == null) return null;

        TreeLinkNode parrent = pNode.next;
        if (pNode == parrent.left) return parrent;

        while (parrent != null && pNode != null && parrent.next != null) {
            pNode = parrent;
            parrent = pNode.next;
            if (pNode == parrent.left) return parrent;
        }

        return null;
    }

    private TreeLinkNode findleft(TreeLinkNode node) {
        while (node.left != null) node = node.left;
        return node;
    }
}
