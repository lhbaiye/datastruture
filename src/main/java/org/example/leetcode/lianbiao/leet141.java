package org.example.leetcode.lianbiao;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description
 * @date 2023/12/23 15:30:19
 */
public class leet141 {
    /**
     * 2n n
     * n + l * m = 2n + k * m
     * n =
     */
    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && slow != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
