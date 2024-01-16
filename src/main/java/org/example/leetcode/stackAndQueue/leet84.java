package org.example.leetcode.stackAndQueue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 * @date 2023/12/23 20:41:34
 */
public class leet84 {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] l = new int[n], r = new int[n];
        Arrays.fill(l, -1); Arrays.fill(r, n);
        Deque<Integer> d = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!d.isEmpty() && heights[d.peekLast()] > heights[i]) {
                r[d.pollLast()] = i;
            }
            d.addLast(i);
        }

        for (int i = n-1; i >= 0 ; i--) {
            while (!d.isEmpty() && heights[d.peekLast()] > heights[i]) {
                l[d.pollLast()] = i;
            }
            d.addLast(i);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            int t = heights[i], a = l[i], b = r[i];
            ans = Math.max(ans, (b - a - 1) * t);
        }
        return ans;
    }
}
