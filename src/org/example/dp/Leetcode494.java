package org.example.dp;

/**
 * 给你一个整数数组 nums 和一个整数 target 。
 * 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
 * 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
 * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目
 */
public class Leetcode494 {
    //left - (sum - left) = target -> left = (target + sum)/2
    public int findTargetSumWays(int[] nums, int target) {
        int n=nums.length;
        int sum=0;
        for (int i = 0; i < n; i++) {
            sum+=nums[i];
        }
        int size=(target+sum)/2;
        if ((target+sum)%2!=0) return 0;
        if (size<0) size=-size;
        //dp[i][j]表示0-i的下标的数组成j的大小的个数
        int[] dp=new int[size+1];
        dp[0]=1;
        for (int i = 0; i < n; i++) {
            for (int j = size; j >=nums[i]; j--) {
                dp[j]+=dp[j-nums[i]];
            }
        }
        return dp[size];
    }
}
