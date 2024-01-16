package org.example.leetcode.lianbiao;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * @date 2023/12/22 21:32:22
 */
public class leet89 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = head;
        while (temp != null) {
            while (temp.next != null && temp.val == temp.next.val) {
                temp.next = temp.next.next;
            }
            temp = temp.next;
        }
        return head;
    }
}
