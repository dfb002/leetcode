package org.example.dp;

import java.util.Arrays;

/**
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 * 你可以认为每种硬币的数量是无限的。
 */
public class Leetcode322 {
    public int coinChange(int[] coins, int amount) {
        //dp[i]表示可以组成i的金额的最少硬币数
        int[] dp=new int[amount+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <=amount ; j++) {
                if (dp[j-coins[i]]!=Integer.MAX_VALUE){
                    dp[j]=Math.min(dp[j],dp[j-coins[i]]+1);
                }
            }
        }
        return dp[amount]==Integer.MAX_VALUE?-1:dp[amount];
    }
}
