package org.example.daimasuixianglu.lianbiao;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description 设计链表
 * @date 2024/1/1 15:52:53
 */
public class leet707 {

}

class MyLinkedList {
    ListNode head;
    int size = 0;
    public MyLinkedList() {
        size = 0;
        this.head = new ListNode(0);
    }
    public int get(int index) {
        if (index < 0 || index > size) {
            return -1;
        }
        ListNode temp = head;
        int i = 0;
        for (; i <= index; i++) {
            if (temp.next == null) {
                return -1;
            } else {
                temp = temp.next;
            }
        }
        return temp.val;
    }

    public void addAtHead(int val) {
        ListNode node = new ListNode(val);
        node.next = head.next;
        head.next = node;
        size++;
    }

    public void addAtTail(int val) {
        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new ListNode(val);
        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        if (index < 0) {
            index = 0;
        }
        size++;
        ListNode prev = head;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        ListNode toAdd = new ListNode(val);
        toAdd.next = prev.next;
        prev.next = toAdd;
    }

    //删除第index个节点
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        size--;
        if (index == 0) {
            head = head.next;
            return;
        }
        ListNode pred = head;
        for (int i = 0; i < index ; i++) {
            pred = pred.next;
        }
        pred.next = pred.next.next;
    }

}