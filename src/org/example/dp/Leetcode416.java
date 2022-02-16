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
        int[] dp=new int[target+1];
        for (int i = 0; i < n; i++) {
            for (int j = target; j >=nums[i] ; j--) {
               dp[j]=Math.max(dp[j],dp[j-nums[i]]+nums[i]);
            }
        }
        return dp[target]==target;
    }
}
