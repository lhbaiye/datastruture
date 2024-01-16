package org.example.daimasuixianglu.array;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description
 * @date 2023/12/31 22:21:33
 */
public class leet26 {
    public int removeDuplicates(int[] nums) {
        int l = 0;
        for (int r = 1; r < nums.length; r++) {
            if (nums[r] != nums[l]) {
                nums[++l] = nums[r];
            }
        }
        return l + 1;
    }
}
