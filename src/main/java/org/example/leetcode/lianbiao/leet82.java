package org.example.leetcode.lianbiao;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现的数字。
 * @date 2023/12/23 13:36:05
 */

public class leet82 {
    public ListNode deleteDuplicates(ListNode head) {
        // 可能头节也需要被删除，然后开始遍历， 从tem.next开始
        if (head == null) {
            return null;
        }
        // 可能头节也需要被删除
        ListNode newHead = new ListNode(-1, head);
        ListNode temp = newHead;
        int n = 0; // 记录当前值是什么
        // 需要判断当前的下一个和在下一个是否为Null
        while (temp.next != null && temp.next.next != null) {
            // 如果相等，则需要从temp.next往下走
            if (temp.next.val == temp.next.next.val) {
                n = temp.next.val;
                while (temp.next != null && temp.next.val == n) {
                    temp.next = temp.next.next;
                }
            } else {
                temp = temp.next;
            }
        }
        return newHead.next;
    }
}