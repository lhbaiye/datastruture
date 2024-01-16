package org.example.leetcode.stackAndQueue;

import java.util.Stack;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *
 * @date 2023/12/23 20:30:36
 */
public class leet20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (Character c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else if (stack.isEmpty() || !c.equals(stack.pop())) {
                return false;
            }
        }
        return true;
    }
}
