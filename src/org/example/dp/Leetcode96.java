package org.example.dp;

/**
 * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数
 */
public class Leetcode96 {
    public int numTrees(int n) {
        //dp[i]表示从1-i的二叉搜索树的个数
        int[] dp=new int[n+1];
        //dp[0]表示一颗空二叉树
        dp[0]=1;
        for (int i = 1; i <= n; i++) {
            //确定不同的j为头结点的个数
            for (int j = 1; j <= i; j++) {
                //j-1 为j为头结点左子树节点数量，i-j 为以j为头结点右子树节点数量
                dp[i]+=dp[i-j]*dp[j-1];
            }
        }
        return dp[n];
    }
}
