package org.example.daimasuixianglu.lianbiao;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description
 * @date 2024/1/1 15:44:21
 */
public class leet203 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode newHead = new ListNode(0, head);
        ListNode temp = newHead;
        while (temp != null && temp.next != null) {
            if (temp.next.val == val) {
                temp.next = temp.next.next;
                continue;
            }
            temp = temp.next;
        }
        return newHead.next;
    }
}
