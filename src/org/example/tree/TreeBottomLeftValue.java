package org.example.tree;

import java.util.LinkedList;

/**
 * 找到二叉树的最后一层的最左边的节点
 */
public class TreeBottomLeftValue {

    public int findBottomLeftValue(TreeNode root) {
        int ans = 0;
        LinkedList<TreeNode> q=new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty())
        {
            int size = q.size();
            for (int i=0;i<size;i++)
            {
                TreeNode node = q.poll();
                if (i==0) {
                    ans = node.val;
                }
                if (node.left!=null) q.offer(node.left);
                if (node.right!=null) q.offer(node.right);
            }
        }
        return ans;
    }
}
