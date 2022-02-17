package org.example.tree;

/**
 * 最大二叉树
 * 创建一个根节点，其值为 nums 中的最大值。
 * 递归地在最大值 左边 的 子数组前缀上 构建左子树。
 * 递归地在最大值 右边 的 子数组后缀上 构建右子树。
 */
public class MaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTree(nums,0,nums.length);
    }
    public TreeNode constructMaximumBinaryTree(int[] nums,int left, int right) {
        if (right-left<1){
            return null;
        }
        if (right-left==1){
            return new TreeNode(nums[left]);
        }
        int maxIndex=left;
        int maxValue = nums[maxIndex];
        for (int i = left+1; i < right; i++) {
            if (nums[i]>maxValue){
                maxValue = nums[i];
                maxIndex = i;
            }
        }
        TreeNode root = new TreeNode(maxValue);
        root.left=constructMaximumBinaryTree(nums,left,maxIndex);
        root.right=constructMaximumBinaryTree(nums,maxIndex+1,right);
        return root;
    }
}
