package org.example.leetcode.lianbiao;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description 反转一个单链表
 * @date 2023/12/23 13:50:19
 */
public class leet206 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null, cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}
