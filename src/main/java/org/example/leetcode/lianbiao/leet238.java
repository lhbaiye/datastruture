package org.example.leetcode.lianbiao;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description
 * @date 2023/12/23 15:58:24
 */

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class leet238 {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        // 复制节点，紧挨到到后面
        // 1->2->3  ==>  1->1'->2->2'->3->3'
        Node cur = head;
        while (cur != null) {
            Node cloneNode = new Node(cur.val);
            cloneNode.next = cur.next;
            Node temp = cur.next;
            cur.next = cloneNode;
            cur = temp;
        }
        // 处理random指针
        cur = head;
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        // 分离两个链表
        cur = head;
        Node cloneHead = cur.next;
        while (cur != null && cur.next != null) {
            Node temp = cur.next;
            cur.next = cur.next.next;
            cur = temp;
        }
        return cloneHead;
    }
}
