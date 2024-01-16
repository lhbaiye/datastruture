package org.example.daimasuixianglu.array;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description
 * @date 2023/12/31 23:09:22
 */
public class leet977 {
    public int[] sortedSquares(int[] nums) {
        int len = nums.length;
        int[] result = new int[len];
        int l = 0, r = len - 1, k = len - 1;
        while (l <= r) {
            int lVal = nums[l] * nums[l];
            int rVal = nums[r] * nums[r];
            if (lVal < rVal) {
                result[k--] = rVal;
                r--;
            } else {
                result[k--] = lVal;
                l++;
            }
        }
        return result;
    }
}
