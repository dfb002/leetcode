package org.example.dp;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish”）。
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * 网格中的障碍物和空位置分别用 1 和 0 来表示
 */
public class Leetcode63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        if (obstacleGrid==null||n==0) return 0;
        int m = obstacleGrid[0].length;
        int[][] dp=new int[n][m];
        //如果当前有障碍物，则后续的路径都不通
        for (int i = 0; i < n&&obstacleGrid[i][0]==0; i++) {
            dp[i][0]=1;
        }
        for (int i = 0; i < m&&obstacleGrid[0][i]==0; i++) {
            dp[0][i]=obstacleGrid[0][i]==1?0:1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (obstacleGrid[i][j]==0)
                {
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
                }
            }
        }
        return dp[n-1][m-1];
    }
}
