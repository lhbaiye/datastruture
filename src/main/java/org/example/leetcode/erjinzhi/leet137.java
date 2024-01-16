package org.example.leetcode.erjinzhi;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description
 * @date 2023/12/27 11:48:00
 */
public class leet137 {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < 64; i++) {
            int sum = 0;
            for (int n : nums) {
                sum += ((n >> i) & 1);
            }
            // 还原
            result |= ((sum % 3) << i);
        }
        return result;
    }
}
