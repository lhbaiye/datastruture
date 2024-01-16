package org.example.leetcode.dongtaiguihua;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description
 * @date 2023/12/25 20:36:29
 */
public class leet300 {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            // 注意默认为1，即此处最长子序列为自身
            int maxLen = 1;
            // dp[i] = dp[i-1] + 1
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    maxLen = Math.max(maxLen, dp[j] + 1);
                }
            }
            dp[i] = maxLen;
        }
        int maxNum = 0;
        for (int item : dp) {
            maxNum = Math.max(maxNum, item);
        }
        return maxNum;
    }
}
