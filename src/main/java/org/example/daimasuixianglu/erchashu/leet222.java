package org.example.daimasuixianglu.erchashu;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description
 * @date 2024/1/7 12:52:37
 */
public class leet222 {

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        int leftDepth = 0, rightDepth = 0;
        while (left != null) {
            leftDepth ++;
            left = left.left;
        }
        while (right != null) {
            rightDepth++;
            right = right.right;
        }
        if (leftDepth == rightDepth) {
            return (2 << leftDepth) - 1;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}
