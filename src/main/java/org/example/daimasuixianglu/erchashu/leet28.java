package org.example.daimasuixianglu.erchashu;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description
 * @date 2024/1/8 15:44:53
 */
public class leet28 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val > q.val) {
            TreeNode temp = p;
            p = q;
            q = temp;
        }
        if (p.val < root.val && root.val < q.val) {
            return root;
        }
        if (q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (root.val < p.val){
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }
}
