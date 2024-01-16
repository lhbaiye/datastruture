package org.example.daimasuixianglu.erchashu;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description
 * @date 2024/1/8 18:31:16
 */
public class leet669 {

    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }
        // 如果满足裁剪要求，开始裁剪
        if (root.val < low) {
            root.left = null;
            return trimBST(root.right, low, high);
        } else if (root.val > high) {
            root.right = null;
            return trimBST(root.left, low, high);
        } else {
            root.left = trimBST(root.left, low, high);
            root.right = trimBST(root.right, low, high);
        }
        return root;
    }
}
