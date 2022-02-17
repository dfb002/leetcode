package org.example.tree;

/**
 * 寻找二叉树的根节点到叶子节点的最小距离
 */
public class MinDepth {

    public int minDepth(TreeNode root){
        return getMinDepth(root);
    }

    public int getMinDepth(TreeNode node){
        if (node==null) return 0;
        int left = getMinDepth(node.left);
        int right = getMinDepth(node.right);

        if (node.left!=null&&node.right==null){
            return 1+left;
        }
        if (node.left==null&&node.right!=null){
            return 1+right;
        }
        return 1+Math.min(left,right);
    }
}
