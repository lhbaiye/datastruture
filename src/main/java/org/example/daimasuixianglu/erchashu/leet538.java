package org.example.daimasuixianglu.erchashu;

import java.util.Stack;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description
 * @date 2024/1/8 19:12:21
 */
public class leet538 {

    // 右 中 左 的遍历方式
    // 定义一个parent， 当前节点的值，等于parent + val
    TreeNode parent = null;
    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        convertBST(root.right);
        if (parent == null) {
            parent = root;
        } else {
            root.val = parent.val + root.val;
            parent = root;
        }
        convertBST(root.left);
        return root;
    }

    public TreeNode convertBST1(TreeNode root) {
        if (root == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        int pre = 0;
        while (!stack.isEmpty() || node != null) {
            if (node != null) {
                stack.push(node);
                node = node.right;
            } else {
                node = stack.pop();
                // 处理
                node.val = node.val + pre;
                pre = node.val;
                // 往左边看
                node = node.left;
            }
        }
        return root;
    }
}
