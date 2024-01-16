package org.example.daimasuixianglu.erchashu;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description
 * @date 2024/1/5 23:26:11
 */
public class bianli {
    public void preOrder(TreeNode head) {
        Stack<TreeNode> stack = new Stack<>();
        if (head == null) {
            return;
        }
        stack.push(head);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.println(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }

//    public void inOrder(TreeNode head) {
//        Stack<TreeNode> stack = new Stack<>();
//        // 先把所有节点压入栈中
//        if (head == null) {
//            return;
//        }
//        TreeNode node = head;
//        while (!stack.isEmpty() || node != null) {
//            if (node != null) {
//                stack.push(node);
//                node = node.left;
//            } else {
//                node = stack.pop();
//                System.out.println(node.val);
//                node = node.right;
//            }
//        }
//    }
    public void inOrder(TreeNode head) {
        List<Integer> result = new LinkedList<>();
        Stack<TreeNode> st = new Stack<>();
        if (head != null) {
            st.push(head);
        }
        while (!st.isEmpty()) {
            TreeNode node = st.peek();
            if (node != null) {
                st.pop(); //将这个节点弹出来
                if (node.right != null) {
                    st.push(node.right);
                }
                if (node.left != null) {
                    st.push(node.left);
                }
                st.push(node);
                st.push(null);// 中节点访问过，但是还没有处理，加入空节点做为标记。
            } else {
                st.pop();
                node = st.peek();
                st.pop();
                System.out.println(node.val);
            }
        }
    }
}
