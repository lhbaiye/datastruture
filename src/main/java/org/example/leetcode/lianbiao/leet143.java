package org.example.leetcode.lianbiao;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 * 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * @date 2023/12/23 15:08:42
 */
public class leet143 {
    /**
     * 先找到中间节点，然后把后面的都反转了，然后逐个插入，其实用栈也可以做
     * @param head
     */
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        // 找中间的节点
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // 此时slow为中间节点，反转后面的
        ListNode p = head;
        ListNode q = reverseList(slow.next);
        // 此时开始插入
        slow.next = null;
        while (q != null && p != null) {
            ListNode qNext = q.next;
            q.next = p.next;
            p.next = q;
            p = q.next;
            q = qNext;
        }
    }

    private ListNode reverseList(ListNode head) {
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
