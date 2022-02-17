package org.example.tree;

/**
 * 判断一个二叉树是否是平衡二叉树
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
 */
public class BalancedTree {

    public boolean isBalanced(TreeNode root) {
        return getHeight(root)==-1?false:true;
    }
    //返回以node为根节点的二叉树的高度，如果不是平衡二叉树返回-1
    public int getHeight(TreeNode node){
        if (node==null){
            return 0;
        }
        int leftHeight = getHeight(node.left);
        if (leftHeight==-1) {
            return -1;
        }
        int rightHeight = getHeight(node.right);
        if (rightHeight==-1){
            return -1;
        }
        if (Math.abs(rightHeight-leftHeight)>1){
            return -1;
        }
        return 1+Math.max(leftHeight,rightHeight);

    }
}
