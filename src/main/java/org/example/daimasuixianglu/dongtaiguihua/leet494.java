package org.example.daimasuixianglu.dongtaiguihua;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description
 * @date 2024/1/16 23:06:42
 */
public class leet494 {
    public int findTargetSumWays(int[] nums, int target) {
        // 01背包应用之“有多少种不同的填满背包最大容量的方法“
        // 易于理解的二维数组解法及详细注释

        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        if ( target < 0 && sum < -target) return 0;
        if ((target + sum) % 2 != 0) return 0;
        int size = (target + sum) / 2;
        if(size < 0) size = -size;
        int[] dp = new int[size + 1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = size; j >= nums[i]; j--) {
                dp[j]+=dp[i-nums[j]];
            }
        }
        return dp[size];
    }
}
