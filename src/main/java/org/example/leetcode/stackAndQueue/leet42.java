package org.example.leetcode.stackAndQueue;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * @date 2023/12/23 23:08:31
 */
public class leet42 {
    public int trap(int[] height) {
        int ans = 0;
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (height[left] < height[right]) {
                ans+=leftMax - height[left];
                left++;
            } else {
                ans += rightMax - height[right];
                --right;
            }
        }
        return ans;
    }
}
