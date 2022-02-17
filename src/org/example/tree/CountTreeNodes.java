package org.example.tree;

/**
 * 计算完全二叉树的节点个数
 */
public class CountTreeNodes {

    public int countNodes(TreeNode root) {
        if (root==null){
            return 0;
        }
        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);
        if (leftDepth==rightDepth){
            // 2^leftDepth其实是 （2^leftDepth - 1） + 1 ，左子树 + 根结点
            return (1<<leftDepth)+countNodes(root.right);
        }else{
            return (1<<rightDepth)+countNodes(root.left);
        }
    }

    public int getDepth(TreeNode node){
        int depth = 0;
        while (node!=null){
            node=node.left;
            depth++;
        }
        return depth;

    }

}
