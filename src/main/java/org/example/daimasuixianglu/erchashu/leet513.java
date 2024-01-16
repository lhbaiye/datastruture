package org.example.daimasuixianglu.erchashu;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description
 * @date 2024/1/7 14:42:51
 */
public class leet513 {
    int maxDepth = Integer.MIN_VALUE;   // 全局变量 记录最大深度
    int result;       // 全局变量 最大深度最左节点的数值
    public int findBottomLeftValue(TreeNode root) {
        dfs(root, 0);
        return result;
    }

    public void dfs(TreeNode node, int depth) {
        if (node.left == null && node.right == null) {
            if (depth > maxDepth) {
                maxDepth = depth;
                result = node.val;
            }
            return;
        }
        if (node.left != null) {
            dfs(node.left, depth + 1);
        }
        if (node.right != null) {
            dfs(node.right, depth + 1);
        }
    }
}
