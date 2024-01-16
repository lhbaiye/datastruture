package org.example.leetcode.lianbiao;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description 给定一个头结点为 head 的非空单链表，返回链表的中间结点。
 * 如果有两个中间结点，则返回第二个中间结点。
 * @date 2023/12/23 15:02:47
 */
public class leet876 {
    public ListNode middleNode(ListNode head) {
        ListNode p = head, q = head;
        while (q != null && q.next != null) {
            p = p.next;
            q = q.next.next;
        }
        return p;
    }
}
