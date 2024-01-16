package org.example.leetcode.erchashu;

import java.util.*;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 * @date 2023/12/24 14:49:40
 */
public class leet257 {
    public List<String> binaryTreePaths(TreeNode root) {
        StringBuilder path = new StringBuilder();
        List<String> paths = new LinkedList<>();
        dfs(root, path, paths);
        return paths;
    }

    private void dfs(TreeNode p, StringBuilder path , List<String> paths) {
        // 如果该节点的左子节点为空，
        if (p == null) {
            return;
        }
        path.append(p.val);
        if (p.left == null && p.right == null) {
            paths.add(path.toString());
        } else {
            path.append("=>");
            dfs(p.left, new StringBuilder(path), paths);
            dfs(p.right, new StringBuilder(path), paths);
        }
    }
    public List<String> levelOrder(TreeNode root) {
        List<String> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        //创建两个队列
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<String > pathQueue = new LinkedList<>();
        nodeQueue.offer(root);
        pathQueue.offer(Integer.toString(root.val));
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            String path = pathQueue.poll();
            // 如果 node的两个子节点都是空，一条路径完毕哦
            if (node.left == null && node.right == null) {
                result.add(path);
            } else {
                // 如果左节点不空，加入
                if (node.left != null) {
                    nodeQueue.offer(node.left);
                    pathQueue.offer(new StringBuffer(path).append("->").append(node.left.val).toString());
                }
                if (node.right != null) {
                    nodeQueue.offer(node.right);
                    pathQueue.offer(new StringBuffer(path).append("->").append(node.right.val).toString());
                }
            }
        }
        return result;
    }

}
