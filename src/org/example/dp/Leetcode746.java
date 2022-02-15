package org.example.dp;

/**
 * 给你一个整数数组 cost ，其中 cost[i] 是从楼梯第 i 个台阶向上爬需要支付的费用。一旦你支付此费用，即可选择向上爬一个或者两个台阶。
 * 你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯。
 * 请你计算并返回达到楼梯顶部的最低花费
 *
 */
public class Leetcode746 {

    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        //dp[i]表示到达第i个台阶所需要的最小费用
        int[] dp=new int[n];
        dp[0]=cost[0];
        dp[1]=cost[1];
        for (int i=2;i<n;i++)
        {

            dp[i]= Math.min(dp[i-1],dp[i-2])+cost[i];
        }
        //最后一步可以理解为不需要花费到达顶部的cost
        return Math.min(dp[n-1],dp[n-2]);
    }

}
