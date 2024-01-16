package org.example.daimasuixianglu.zhanheduilie;

import java.util.Stack;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description 使用栈实现队列的下列操作：
 * @date 2024/1/5 12:28:08
 */
public class leet232 {
}

class MyQueue {
    Stack<Integer> s1 = new Stack<>(); // 负责进栈
    Stack<Integer> s2 = new Stack<>(); // 负责出栈
    public MyQueue() {

    }

    public void push(int x) {
        s1.push(x);
    }

    public int pop() {

        dumpstackIn();
        return s2.pop();
    }

    public int peek() {
        dumpstackIn();
        return s2.peek();
    }

    // 如果stackOut为空，那么将stackIn中的元素全部放到stackOut中
    private void dumpstackIn() {
        if (!s2.isEmpty()) {
            return;
        }
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
    }

    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}