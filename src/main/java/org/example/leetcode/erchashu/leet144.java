package org.example.leetcode.erchashu;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 * @date 2023/12/24 13:35:48
 */
public class leet144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        traversal(root, result);
        return result;
    }

    public void traversal(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        traversal(root.left, result);
        traversal(root.right, result);
    }

    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode p = stack.pop();
            result.add(p.val);
            if (p.right != null) {
                stack.push(p.right);
            }
            if (p.left != null) {
                stack.push(p.left);
            }
        }
        return result;
    }

    public static void inOrderIteration(TreeNode head) {
        if (head == null) {
            return;
        }
        List<Integer> result = new ArrayList<>();
        TreeNode cur = head;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.right != null) {
                cur = cur.right;
            }
        }
    }

    public static List inOrderIteration2(TreeNode head) {
        List<Integer> result = new ArrayList<>();
        if (head == null) {
            return result;
        }
        TreeNode cur = head;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            // 此时可以输入节点了
            TreeNode node = stack.pop();
            result.add(node.val);
            // 开始右边的节点
            if (node.right != null) {
                cur = node.right;
            }
        }
        return result;
    }


    public static void postOrderIteration(TreeNode head) {
        if (head == null) {
            return;
        }
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        stack1.push(head);
        while (!stack1.isEmpty()) {
            TreeNode node = stack1.pop();
            stack2.push(node);
            if (node.left != null) {
                stack1.push(node.left);
            }
            if (node.right != null) {
                stack1.push(node.right);
            }
        }

        while (!stack2.isEmpty()) {
            System.out.print(stack2.pop().val + " ");
        }
    }

}
