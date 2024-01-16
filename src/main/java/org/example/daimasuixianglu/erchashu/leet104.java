package org.example.daimasuixianglu.erchashu;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description
 * @date 2024/1/6 23:07:22
 */
public class leet104 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);
        if (root.left != null && root.right != null) {
            return Math.min(leftDepth, rightDepth) + 1;
        }
        if (root.left == null) {
            return rightDepth + 1;
        }
        return leftDepth + 1;
    }
    public int minDepth(TreeNode root, int depth) {
        if (root.left == null && root.right == null) {
            return depth + 1;
        }
        int leftDepth = Integer.MAX_VALUE;
        int rightDepth = Integer.MAX_VALUE;
        if (root.left != null) {
            leftDepth = minDepth(root.left, depth + 1);
        }
        if (root.right != null) {
            rightDepth = minDepth(root.right, depth + 1);
        }
        return Math.min(leftDepth,  rightDepth);
    }
}
