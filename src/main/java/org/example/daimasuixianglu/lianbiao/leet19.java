package org.example.daimasuixianglu.lianbiao;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description
 * @date 2024/1/1 16:38:51
 */
public class leet19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode newHead = new ListNode(0, head);
        ListNode slow = newHead;
        ListNode fast = newHead;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return newHead.next;
    }
}
