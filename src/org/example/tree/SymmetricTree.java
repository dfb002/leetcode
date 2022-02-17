package org.example.tree;

/**
 * 判断二叉数是否对称
 */
public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        return helper(root.left,root.right);
    }
    public boolean helper(TreeNode node1,TreeNode node2){
        if (node1==null&&node2==null) return true;
        if (node1==null||node2==null||node1.val!=node2.val){
            return false;
        }
        return helper(node1.left,node2.right)&&helper(node1.right,node2.left);
    }

}
