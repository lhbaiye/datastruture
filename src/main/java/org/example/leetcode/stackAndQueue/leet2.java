package org.example.leetcode.stackAndQueue;

import java.util.Stack;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description
 * @date 2023/12/23 23:40:17
 */
public class leet2 {
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    /** Initialize your data structure here. */
    public leet2() {


    }

    // 2里面所有的放回1，然后
    public void push(int x) {
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        stack1.push(x);
    }

    public int pop() {
        // 先将1里面所有的放到2
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        if (stack2.isEmpty()) {
            return -1;
        }
        return stack2.pop();
    }
    public int peed() {
        while (! stack1.isEmpty()) {
            int val = stack1.pop();
            stack2.push(val);
        }
        if (stack2.isEmpty()) {
            return -1;
        }
        return stack2.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}
