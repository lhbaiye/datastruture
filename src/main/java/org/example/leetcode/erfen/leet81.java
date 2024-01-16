package org.example.leetcode.erfen;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description
 * @date 2023/12/25 16:12:34
 */
public class leet81 {
    public boolean search(int[] nums, int target) {
        // 思路：四种情况判断
        if (nums.length == 0) {
            return false;
        }
        int left = 0;
        int right = nums.length - 1;
        while (right - left > 1) {
            // 去除重复元素
            while (left < right && nums[right] == nums[right - 1]) {
                right--;
            }
            while (left < right && nums[left] == nums[left + 1]) {
                left++;
            }
            int mid = left + (right - left) / 2;
            // 相等直接返回
            if (nums[mid] == target) {
                return true;
            }
            // 判断在哪个区间，可能分为四种情况
            if (nums[left] < nums[mid]) {
                if (nums[left] <= target && target <= nums[mid]) {
                    right = mid;
                } else {
                    left = mid;
                }
            } else if (nums[right] > nums[mid]) {
                if (nums[right] >= target && target >= nums[mid]) {
                    left = mid;
                } else {
                    right = mid;
                }
            }
        }
        return (nums[left] == target || nums[right] == target);
    }
}
