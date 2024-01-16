package org.example.leetcode.erfen;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description
 * @date 2023/12/25 15:59:53
 */
public class leet33 {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            // 相等直接返回
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                if (nums[left] > target) {
                    left = mid;
                } else {
                    right = mid;
                }
            } else {
                if (nums[right] >= target) {
                    left = mid;
                } else {
                    right = mid;
                }
            }
        }
        if (nums[left] == target) {
            return left;
        } else if (nums[right] == target) {
            return right;
        }
        return -1;
    }
}
