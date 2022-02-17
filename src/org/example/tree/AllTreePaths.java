package org.example.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 输出二叉树的所有路径(从根节点到叶子节点的路径)
 */
public class AllTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans=new ArrayList<>();
        if (root==null) return ans;
        backtrace(root,new ArrayList<Integer>(),ans);
        return ans;
    }
    public void backtrace(TreeNode node,List<Integer> path,List<String> result){
        path.add(node.val);
        if (node.left == null && node.right == null) {
            // 输出
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < path.size() - 1; i++) {
                sb.append(path.get(i)).append("->");
            }
            sb.append(path.get(path.size() - 1));
            result.add(sb.toString());
            return;
        }
        if (node.left!=null) {
            backtrace(node.left,path,result);
            path.remove(path.size()-1);
        }
        if (node.right!=null) {
            backtrace(node.right,path,result);
            path.remove(path.size()-1);
        }

    }
}
