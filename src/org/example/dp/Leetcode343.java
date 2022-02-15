package org.example.dp;

/**
 * 给定一个正整数 n ，将其拆分为 k 个 正整数 的和（ k >= 2 ），并使这些整数的乘积最大化。
 * 返回 你可以获得的最大乘积 。
 */
public class Leetcode343 {
    public int integerBreak(int n) {
        //dp[i]表示拆分数字i后得到的最大乘积
        int[] dp=new int[n+1];
        dp[2]=1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <i-1; j++) {
                //将i进行拆分为j,i-j这部分的最大值
                dp[i]=Math.max(dp[i],Math.max((i-j)*j,dp[i-j]*j));
            }
        }
        return dp[n];
    }
}
