package org.example.leetcode.tanxin;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description
 * @date 2023/12/26 19:33:15
 */
public class leet45 {
    public int jump(int[] nums) {
        int length = nums.length;
        int step = 0;
        int end = 0;
        int maxPosition = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                step++;
            }
        }
        return step;
    }
}
