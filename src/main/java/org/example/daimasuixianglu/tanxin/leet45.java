package org.example.daimasuixianglu.tanxin;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description
 * @date 2024/1/13 21:11:11
 */
public class leet45 {
    public int jump(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return 0;
        }
        int curDistance = 0;
        int maxDistance = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            maxDistance = Math.max(maxDistance, i + nums[i]);
            if (maxDistance >= nums.length - 1) {
                count++;
                break;
            }
            if (i == curDistance) {
                curDistance = maxDistance;
                count++;
            }
        }
        return count;
    }
}
