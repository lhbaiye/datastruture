package org.example.leetcode.erchashu;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 * @date 2023/12/24 15:52:52
 */
public class leet98 {
    public boolean isValidBST(TreeNode root) {
        return divideAndConquer(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean divideAndConquer(TreeNode p, long min, long max) {
        if (p == null) {
            return true;
        }
        if (p.val <= min || p.val >= max) {
            return false;
        }
        boolean left = divideAndConquer(p.left, min, p.val);
        boolean right = divideAndConquer(p.right, p.val, max);
        return left && right;
    }
}
