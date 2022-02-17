package org.example.tree;

public class SumOfLeftLeaves {

    public int sumOfLeftLeaves(TreeNode root) {
        if (root==null) return 0;
        int leftSum = sumOfLeftLeaves(root.left);
        int rightSum = sumOfLeftLeaves(root.right);
        int value=0;
        if (root.left!=null&&root.left.left==null&&root.left.right==null){
            value+=root.left.val;
        }
        return value+leftSum+rightSum;

    }
}
