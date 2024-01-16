package org.example.daimasuixianglu.erchashu;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description
 * @date 2024/1/7 15:14:56
 */
public class leet113 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        if (root == null) {
            return result;
        }
        dfs(root, targetSum, result, path);
        return result;
    }

    private void dfs(TreeNode root, int targetSum, List<List<Integer>> result, List<Integer> path) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null && root.val == targetSum) {
            path.add(root.val);
            result.add(path);
            return;
        }
        path.add(root.val);
        dfs(root.left, targetSum - root.val, result, new ArrayList<>(path));
        dfs(root.right, targetSum - root.val, result, new ArrayList<>(path));
        path.remove(path.size() - 1);
    }
}
