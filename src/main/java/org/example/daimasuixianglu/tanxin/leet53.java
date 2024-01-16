package org.example.daimasuixianglu.tanxin;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description
 * @date 2024/1/13 19:57:16
 */
public class leet53 {
    public int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int sum = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            count+=nums[i];
            sum = Math.max(count, sum);
            if (count <= 0) {
                count = 0;
            }
        }
        return sum;
    }
}
