package org.example.leetcode.lianbiao;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 * @date 2023/12/23 14:01:03
 */
public class leet92 {
    // 先找到第m个节点的前一个节点。
    // 循环的条件解释 计数器等于N
    // 剩下的 继续pre 和cur两个节点。
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode newHead = new ListNode(0, head);
        ListNode temp = newHead;
        for (int i = 0; i < m - 1; i++) {
            temp = temp.next;
        }
        // 此时temp到了m-1个节点处，也就是说第m个节点的前一个
        ListNode pre = null;
        ListNode cur = temp.next;
        for (int i = m; i <= n; i++) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        temp.next.next = cur;
        temp.next = pre;

        return newHead.next;
    }

}
