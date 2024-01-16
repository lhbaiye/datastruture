package org.example.leetcode.erfen;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置
 * @date 2023/12/25 14:46:04
 */
public class leet35 {

    public static void main(String[] args) {
        leet35 leet35 = new leet35();
        int[] num = {1,3,5,6};
        leet35.searchInsert(num, 5);
    }
    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end - 1) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        // 这时候只有两个元素了
        if (nums[start] >= target) {
            return start;
        } else if (nums[start] < target && target <= nums[end]) {
            return end;
        } else {
            return end + 1;
        }
    }
}
