package org.example.dp;

/**
 * 给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
 * 请你找出并返回 strs 的最大子集的长度，该子集中 最多 有 m 个 0 和 n 个 1 。
 * 如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。
 */
public class Leetcode474 {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp=new int[m+1][n+1];
        int oneCnt,zeroCnt;
        for(String str : strs){
            oneCnt=0;
            zeroCnt=0;
            for (char ch : str.toCharArray())
            {
                if (ch=='0') zeroCnt++;
                else oneCnt++;
            }
            for (int i = m; i >=zeroCnt; i--) {
                for (int j = n; j >= oneCnt; j--) {
                    dp[i][j]=Math.max(dp[i][j],dp[i-zeroCnt][j-oneCnt]+1);
                }
            }
        }
        return dp[m][n];
    }
}
