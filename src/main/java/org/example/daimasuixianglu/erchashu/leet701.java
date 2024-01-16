package org.example.daimasuixianglu.erchashu;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description
 * @date 2024/1/8 16:00:07
 */
public class leet701 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        TreeNode cur = root;
        TreeNode prev = null;
        while (cur != null) {
            prev = cur;
            if (cur.val > val) {
                cur = cur.left;
            } else if (cur.val < val) {
                cur = cur.right;
            }
        }
        if (prev.left == null && prev.val > val) {
            prev.left = new TreeNode(val);
        } else {
            prev.right = new TreeNode(val);
        }
        return root;
    }
}
