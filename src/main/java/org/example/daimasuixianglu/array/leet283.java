package org.example.daimasuixianglu.array;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description
 * @date 2023/12/31 22:35:00
 */
public class leet283 {
    public void moveZeroes(int[] nums) {
        int l = 0;
        for (int r = 0; r < nums.length; r++) {
            if (nums[r] != 0) {
                nums[l++] = nums[r];
            }
        }
        for (int i = l; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
