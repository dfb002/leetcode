package org.example.dp;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 *
 * 问总共有多少条不同的路径？
 */
public class Leetcode62 {

    public int uniquePaths(int m, int n) {
        //dp[i]表示到达i，j的下标的网格总共有多少条路径
        int[][] dp=new int[m][n];
        //在边界的路径为1
        for(int i=0;i<m;i++){
            dp[i][0]=1;
        }
        for (int i=0;i<n;i++){
            dp[0][i]=1;
        }
        for (int i=1;i<m;i++){
            for (int j=1;j<n;j++)
            {
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m][n];
    }
}
