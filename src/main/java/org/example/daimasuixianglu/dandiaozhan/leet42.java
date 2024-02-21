package org.example.daimasuixianglu.dandiaozhan;

import java.util.Stack;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description
 * @date 2024/1/19 14:46:52
 */
public class leet42 {
    public int trap(int[] height){
        int size = height.length;

        if (size <= 2) {
            return 0;
        }

        // in the stack, we push the index of array
        // using height[] to access the real height
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(0);

        int sum = 0;
        for (int index = 1; index < size; index++){
            int stackTop = stack.peek();
            if (height[stackTop] > height[index]) {
                stack.push(index);
            } else if (height[stackTop] == height[index]) {
                stack.pop();
                stack.push(index);
            } else {
                int heightAtIdx = height[index];
                while (!stack.isEmpty() && heightAtIdx > height[stackTop]) {
                    int mid = stack.pop();
                    if (!stack.isEmpty()) {
                        int left = stack.pop();
                        int h = Math.min(height[left], height[index]) - height[mid];
                        int w = index - left - 1;
                        int hold = h * w;
                        if (hold > 0) {
                            sum += hold;
                        }
                        stackTop = stack.peek();
                    }
                }
                stack.push(index);
            }
        }

        return sum;
    }
}
