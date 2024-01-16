package org.example.leetcode.lianbiao;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description 给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * @date 2023/12/23 14:47:02
 */
public class leet23 {
    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }
    public ListNode merge(ListNode[] lists, int begin, int end) {
        if (begin == end) {
            return lists[begin];
        }
        if (begin > end) {
            return null;
        }
        int mid = (begin + end) >> 1;
        return mergeTwoLists(merge(lists, begin, mid), merge(lists, mid + 1, end));
    }

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
