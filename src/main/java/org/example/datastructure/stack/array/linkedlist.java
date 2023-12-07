package org.example.datastructure.stack.array;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description 链表模拟栈
 * @date 2023/12/7 21:32:19
 */
public class linkedlist {
    private int maxSize;
    private int size;
    private Node top;

    public linkedlist(int maxSize) {
        this.maxSize = maxSize;
    }

    public boolean isFull() {
        return size == maxSize;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void push(int value) {
        if (isFull()) {
            System.out.println("已满");
            return;
        }
        Node temp = top;
        top = new Node(value);
        top.next = temp;
        size++;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈已空");
        }
        // top 保存的是最后入栈的元素，直接从 top 取出即可
        Node temp = top;
        top = temp.next;
        size--;
        return temp.value;
    }

}


class Node {
    int value;
    Node next;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}