package org.example.daimasuixianglu.erchashu;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description
 * @date 2024/1/6 22:38:48
 */
public class leet637 {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if (root == null) {
            return result;
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            double val = 0;
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.poll();
                val = val + node.val;
                if (i == len - 1) {
                    result.add(val / (len - 1));
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return result;
    }
}
