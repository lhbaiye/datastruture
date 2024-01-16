package org.example.leetcode.erfen;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description
 * @date 2023/12/25 15:28:42
 */
public class leet154 {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        if (nums.length == 0) {
            return -1;
        }
        while (start < end - 1) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < nums[end]) {
                while (start<= mid && nums[mid-1] == nums[mid]) {
                    mid--;
                }
                end = mid;
            } else {
                while (mid < end && nums[mid+1] == nums[mid]) {
                    mid++;
                }
                start = mid;
            }
        }
        return Math.min(nums[start], nums[end]);
    }
}
