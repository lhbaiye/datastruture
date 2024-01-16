package org.example.daimasuixianglu.tanxin;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description
 * @date 2024/1/13 20:54:48
 */
public class leet55 {
    public boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        int coverRange = 0;
        for (int i = 0; i <= coverRange; i++) {
            coverRange = Math.max(coverRange, i + nums[i]);
            if (coverRange >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }
}
