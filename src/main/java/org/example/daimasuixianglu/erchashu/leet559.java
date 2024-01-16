package org.example.daimasuixianglu.erchashu;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description
 * @date 2024/1/7 12:21:52
 */
public class leet559 {
    public int maxDepth(Node root) {
        return maxDepth(root, 0);
    }



    public int maxDepth(Node root, int depth) {
        if (root == null) {
            return depth;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < root.children.size(); i++) {
            max = Math.max(max, maxDepth(root.children.get(i), depth + 1));
        }
        return max;
    }
}
