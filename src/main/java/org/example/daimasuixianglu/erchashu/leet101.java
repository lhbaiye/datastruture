package org.example.daimasuixianglu.erchashu;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description
 * @date 2024/1/6 23:39:13
 */
public class leet101 {
    public boolean isSymmetric(TreeNode root) {
        return dfs(root, root);
    }

    public boolean dfs(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && dfs(p.left, q.right) && dfs(p.right, q.left);
    }
}
