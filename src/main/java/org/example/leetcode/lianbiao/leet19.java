package org.example.leetcode.lianbiao;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。(尝试使用一趟扫描实现)
 * @date 2023/12/23 15:53:30
 */
public class leet19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 考虑到删除第一个节点？
        ListNode newHead = new ListNode(0, head);
        ListNode p1 = newHead, p2 = newHead;
        while (n > 0) {
            p2 = p2.next;
            n--;
        }
        while (p2 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        p1.next = p1.next.next;
        return newHead.next;
    }
}
