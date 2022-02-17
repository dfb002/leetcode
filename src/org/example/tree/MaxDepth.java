package org.example.tree;

/**
 * 二叉树根节点到叶子节点的最大深度
 */
public class MaxDepth {
    public int maxDepth(TreeNode root){
        return getMaxDepth(root);
    }

    private int getMaxDepth(TreeNode node) {
        if (node==null) return 0;
        int left = getMaxDepth(node.left);
        int right = getMaxDepth(node.right);
        return 1+Math.max(left,right);
    }
}
