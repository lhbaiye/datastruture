package org.example.leetcode.lianbiao;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description 请判断一个链表是否为回文链表。
 * @date 2023/12/23 15:24:46
 */
public class leet234 {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 找到中间节点
        // 此时slow为中间节点，反转后面的
        ListNode p = head;
        ListNode q = reverseList(slow.next);
        boolean result = true;
        while (q != null) {
            if (p.val != q.val) {
                result = false;
                break;
            }
            p = p.next;
            q = q.next;
        }
        return result;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
}
