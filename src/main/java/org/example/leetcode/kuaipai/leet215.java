package org.example.leetcode.kuaipai;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description
 * @date 2023/12/27 10:55:08
 */
public class leet215 {
    public int findKthLargest(int[] nums, int k) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int pivotIndex = (l + r) / 2;
            int pivot = partition(nums, l, r);
            if (pivot == k) {
                break;
            } else if (pivot < k) {
                l = pivot + 1;
            } else {
                r = pivot - 1;
            }
        }
        return nums[nums.length - k];
    }

    private int partition(int[] nums, int start, int end) {
        int l = start;
        int r = end + 1;
        while (true) {
            while (nums[++l] < nums[start] && l < end);
            while (nums[--r] > nums[start] && r > start);
            if (l >= r) {
                break;
            }
            swap(nums, l, r);
        }
        swap(nums, start, r);
        return r;
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
