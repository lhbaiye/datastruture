package org.example.leetcode.tanxin;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description
 * @date 2023/12/26 19:24:40
 */
public class leet55 {
    public boolean canJump(int[] nums) {
        int maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            // 当前格子已经无法跳到
            if (i > maxLen) return false;
            // 更新能跳到的最远距离
            maxLen = Math.max(maxLen, i + nums[i]);
        }
        return true;
    }
}
