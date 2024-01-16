package org.example.leetcode.erjinzhi;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description
 * @date 2023/12/27 12:15:46
 */
public class leet201 {
    public int rangeBitwiseAnd(int left, int right) {
        while (left < right) {
            // 抹去最右边的 1
            right = right & (right - 1);
        }
        return right;
    }
}
