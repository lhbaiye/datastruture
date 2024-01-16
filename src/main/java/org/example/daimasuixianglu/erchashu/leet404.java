package org.example.daimasuixianglu.erchashu;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description
 * @date 2024/1/7 14:27:22
 */
public class leet404 {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftVal = sumOfLeftLeaves(root.left);
        int rightVal = sumOfLeftLeaves(root.right);
        int midVal = 0;
        if (root.left != null && root.left.left == null && root.left.right == null) {
            midVal = root.left.val;
        }
        return midVal + leftVal + rightVal;

    }

}
