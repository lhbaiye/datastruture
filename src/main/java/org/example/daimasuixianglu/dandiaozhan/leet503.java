package org.example.daimasuixianglu.dandiaozhan;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description
 * @date 2024/1/19 14:33:58
 */
public class leet503 {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ret = new int[n];
        Arrays.fill(ret, -1);
        Deque<Integer> stack = new LinkedList<Integer>();
        stack.push(0);
        for (int i = 1; i < n * 2 - 1; i++) {
            if (nums[i % n] <= nums[stack.peek()]) {
                stack.push(i % n);
            } else {
                while (!stack.isEmpty() && nums[stack.peek()] < nums[i % n]) {
                    ret[stack.pop()] = nums[i % n];
                }
                stack.push(i % n);
            }
        }
        return ret;
    }
}
