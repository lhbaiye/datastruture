package org.example.leetcode.erchashu;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description
 * @date 2023/12/24 13:34:33
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode() {};
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
