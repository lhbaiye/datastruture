package org.example.leetcode.lianbiao;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description 将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * @date 2023/12/23 14:35:48
 */
public class leet21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newHead = new ListNode();
        ListNode temp = newHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        // 连接未处理完节点
        temp.next = l1 == null ? l2 : l1;
        return newHead.next;
    }
}
