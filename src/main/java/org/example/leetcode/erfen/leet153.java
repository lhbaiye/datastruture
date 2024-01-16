package org.example.leetcode.erfen;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description
 * @date 2023/12/25 15:03:13
 */
public class leet153 {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        if (nums.length == 0) {
            return -1;
        }
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return Math.min(nums[left], nums[right]);

    }
}
