package org.example.leetcode.kuaipai;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description
 * @date 2023/12/27 11:35:25
 */
public class leet75 {
    public void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while (mid <= right) {
            if (nums[mid] == 0) {
                swap(nums, mid, left);
                left++;
                mid++;
            } else if (nums[mid] == 2) {
                swap(nums, right, mid);
                right--;
            } else {
                mid++;
            }
        }
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
