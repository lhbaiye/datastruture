package org.example.daimasuixianglu.erchashu;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description
 * @date 2024/1/8 14:06:14
 */
public class leet700 {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return root;
        }
        while (root != null) {
            if (root.val == val) {
                return root;
            } else if (root.val > val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return null;
    }
}
