package org.example.dp;

/**
 * 给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。
 * 请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。
 * 假设每一种面额的硬币有无限个。 
 * 题目数据保证结果符合 32 位带符号整数。
 */
public class Leetcode518 {
    public int change(int amount, int[] coins) {
        //dp[i]表示凑成i的金额的总的组合数
        int[] dp=new int[amount+1];
        dp[0]=1;
        for (int i = 0; i < coins.length; i++) {
            //此时的dp[i]表示前面i个硬币可以组成amount的组合数为多少
            for (int j = coins[i]; j <= amount; j++) {
                dp[j]+=dp[j-coins[i]];
            }
        }
        return dp[amount];
    }

}
