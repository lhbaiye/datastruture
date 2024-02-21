package org.example.daimasuixianglu.dongtaiguihua;

import org.example.daimasuixianglu.erchashu.TreeNode;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description
 * @date 2024/1/18 11:50:51
 */
public class leet337 {
    public int rob(TreeNode root) {
        int[] res = robAction1(root);
        return Math.max(res[0], res[1]);
    }

    private int[] robAction1(TreeNode root) {
        int res[] = new int[2];
        if (root == null) {
            return res;
        }
        int[] left = robAction1(root.left);
        int[] right = robAction1(root.right);
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        res[1] = root.val + left[0] + right[0];
        return res;
    }

}
