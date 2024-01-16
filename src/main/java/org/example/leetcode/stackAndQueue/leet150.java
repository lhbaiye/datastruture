package org.example.leetcode.stackAndQueue;

import java.util.Stack;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description波兰表达式计算 > 输入: ["2", "1", "+", "3", "*"] > 输出: 9
 * 解释: ((2 + 1) * 3) = 9
 * @date 2023/12/23 16:41:51
 */
public class leet150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String s : tokens) {
            if ("+".equals(s) || "-".equals(s) || "*".equals(s) || "/".equals(s)) {
                int a = stack.pop();
                int b = stack.pop();
                if ("+".equals(s)) {
                    stack.push(b + a);
                } else if ("-".equals(s)) {
                    stack.push(b - a);
                } else if ("*".equals(s)) {
                    stack.push(b * a);
                }
                    // 注意：b为被除数，a为除数
                else if ("/".equals(s)) {
                    stack.push(b / a);
                }
            } else {
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }

}
