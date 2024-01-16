package org.example.leetcode.erchashu;

import java.util.LinkedList;
import java.util.List;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description
 * @date 2023/12/24 18:12:50
 */
public class leet102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        LinkedList<Integer> numList = new LinkedList<>();
        queue.addLast(root);
        numList.addLast(root.val);
        while (!queue.isEmpty()) {
            result.add(0, numList);
            numList = new LinkedList<>();
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.pop();
                if (node.left != null) {
                    queue.addLast(node.left);
                    numList.add(node.left.val);
                }
                if (node.right != null) {
                    queue.add(node.right);
                    numList.add(node.right.val);
                }
            }
        }
        return result;

    }
}
