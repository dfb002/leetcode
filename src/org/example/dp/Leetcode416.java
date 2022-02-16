package org.example.dp;

/**
 * 01背包问题：dp[i][j]表示下标为0-i的物品随便去，放入大小为j的背包的最大价值
 *
 * 给你一个 只包含正整数 的 非空 数组 nums 。
 * 请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等
 */
public class Leetcode416 {

    public boolean canPartition(int[] nums) {
        int n=nums.length;
        int sum=0;
        for (int i = 0; i < n; i++) {
            sum+=nums[i];
        }
        if (sum%2==1) return false;
        int target=sum/2;

        //dp[i][j]表示表示下标为0-i的数字随便取，放入大小为j的背包的最大值
        int[][] dp=new int[n][target+1];
        //初始化,此时只有数字nums[0],如果小于i，则dp[i][j]=nums[0]
        for (int i = nums[0]; i <=target ; i++) {
            dp[0][i]=nums[0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <=target ; j++) {
                if (nums[i]>j) {
                    dp[i][j]=dp[i-1][j];
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-nums[i]]+nums[i]);
                }
            }
        }
        return dp[n-1][target]==target;
    }
}
