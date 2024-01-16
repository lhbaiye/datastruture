package org.example.leetcode.erchashu;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description
 * @date 2023/12/24 15:57:34
 */
public class leet110 {
    public boolean isBalanced(TreeNode root) {
        // 递归计算左子树的高度，和右子树的高度
        return maxDepth(root) > 0;
    }

    private int maxDepth(TreeNode p) {
        if (p == null) {
            return 0;
        }
        int left = maxDepth(p.left);
        int right = maxDepth(p.right);
        if (left < 0 || right < 0 || Math.abs(left - right) > 1) {
            return -1;
        } else {
            return Math.max(left, right) + 1;
        }
    }

}
