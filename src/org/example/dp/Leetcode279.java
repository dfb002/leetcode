package org.example.dp;

import java.util.Arrays;

/**
 * 给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
 *
 * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。
 * 例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
 *
 * 完全背包问题的变体：dp[i]表示和为i的完全平方数的最小值
 * 其中dp[i]=dp[i-j*j]+1得到，此时的j从1开始并且j*j<=i
 */
public class Leetcode279 {
    public int numSquares(int n) {
        int[] dp =new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j*j <= i; j++) {
                dp[i]=Math.min(dp[i],dp[i-j*j]+1);
            }
        }
        return dp[n];
    }
}
