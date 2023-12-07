package org.example.datastructure.stack.array;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description 数组模拟栈
 * @date 2023/12/7 21:20:27
 */
public class ArrayStack {
    private int[] stack; //数据村粗
    private int maxSize; //栈最大位置
    private int top = -1; //栈顶

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        this.stack = new int[maxSize];
    }

    /**
     * 是否已满
     *
     * @return
     */
    public boolean isFull() {
        return maxSize - 1 == top;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(int value) {
        if (isEmpty()) {
            System.out.println("已满");
        }
        stack[++top] = value;
    }

    /**
     * 出栈
     *
     * @return
     */
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈中无数据");
        }
        return stack[top--];
    }

    /**
     * 显示栈中数据，从栈顶开始显示，也就是按出栈的顺序显示
     */
    public void print() {
        if (isEmpty()) {
            System.out.println("栈中无数据");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.printf("index=%d, value=%d \n", i, stack[i]);
        }
    }




}
