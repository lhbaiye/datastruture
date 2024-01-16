package org.example.daimasuixianglu.lianbiao;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description
 * @date 2024/1/1 16:12:42
 */
public class leet24 {
    public ListNode swapPairs(ListNode head) {
        ListNode newHead = new ListNode(0, head);
        ListNode cur = newHead;
        while (cur.next != null && cur.next.next != null) {
            ListNode temp = cur.next.next.next;
            ListNode temp2 = cur.next.next;
            ListNode temp3 = cur.next;
            cur.next = cur.next.next;;
            temp2.next = temp3;
            temp3.next = temp;
            cur = temp3;
        }
        return newHead.next;

    }
}
