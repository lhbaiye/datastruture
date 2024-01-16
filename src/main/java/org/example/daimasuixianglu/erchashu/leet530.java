package org.example.daimasuixianglu.erchashu;

import org.junit.Test;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description
 * @date 2024/1/8 14:34:31
 */
public class leet530 {
    @Test
    public void test1() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        System.out.println(getMinimumDifference(root));

    }
    int pre;
    int ans;
    public int getMinimumDifference(TreeNode root) {
        ans = Integer.MAX_VALUE;
        pre = -1;
        dfs(root);
        return ans;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (pre == -1) {
            pre = root.val;
        } else {
            ans = Math.min(ans, root.val - pre);
            pre = root.val;
        }
        dfs(root.right);
    }
}
