package org.example.daimasuixianglu.array;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description
 * @date 2024/1/1 13:44:12
 */
public class leet209 {
    // dfs
    public int minSubArrayLen(int target, int[] nums) {
        int res = Integer.MAX_VALUE;
        int l = 0;
        int sum = 0;
        // 左右指针，然后右指针往右边移动，每次大于target以后，就所做指针，每次等于的时候，就记录一次结果
        for (int r = 0; r < nums.length; r++) {
            sum+=nums[r];
            while (sum >= target) {
                res = Math.min(res, r - l + 1);
                sum-=nums[l];
                l++;
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }

}
