package org.example.daimasuixianglu.array;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description
 * @date 2023/12/31 21:34:23
 */
public class erfenchazhao {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l < r - 1) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                l = mid;
            } else {
                r = mid;
            }
        }
        if (nums[l] == target) {
            return l;
        } else if (nums[r] == target) {
            return r;
        } else {
            return -1;
        }
    }
}
