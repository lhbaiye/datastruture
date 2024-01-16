package org.example.daimasuixianglu.erchashu;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description
 * @date 2024/1/8 15:01:06
 */
public class leet501 {
    int prev = Integer.MIN_VALUE;
    int nums = 0;
    int maxCount = 0;
    List<Integer> result = new ArrayList<>();
    public int[] findMode(TreeNode root) {
        if (root == null) {
            return result.stream().mapToInt(Integer::intValue).toArray();
        }
        dfs(root);
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (prev == Integer.MIN_VALUE || root.val != prev) {
            nums = 1;
        } else {
            nums++;
        }
        // 更新结果
        if (nums > maxCount) {
            result.clear();;
            result.add(root.val);
            maxCount = nums;
        } else if (nums == maxCount) {
            result.add(root.val);
        }
        prev = root.val;

        dfs(root.right);
    }
}
