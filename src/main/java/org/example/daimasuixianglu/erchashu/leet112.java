package org.example.daimasuixianglu.erchashu;

import java.util.Stack;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description
 * @date 2024/1/7 14:58:19
 */
public class leet112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        stack1.push(root);
        stack2.push(root.val);
        while (!stack1.isEmpty()) {
            TreeNode node = stack1.pop();
            Integer nodeVal = stack2.pop();
            if (node.left == null && node.right == null && nodeVal == targetSum) {
                return true;
            }
            if (node.right != null) {
                stack1.push(node.right);
                stack2.push(nodeVal + node.right.val);
            }
            // 左节点，压进去一个节点的时候，将该节点的路径数值也记录下来
            if(node.left != null) {
                stack1.push(node.left);
                stack2.push(nodeVal + node.left.val);
            }
        }
        return false;
    }
}
