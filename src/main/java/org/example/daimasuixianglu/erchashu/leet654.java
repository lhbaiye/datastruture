package org.example.daimasuixianglu.erchashu;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description
 * @date 2024/1/7 16:38:36
 */
public class leet654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        return buildTree(nums, 0, nums.length);
    }

    public TreeNode buildTree(int[] nums, int left, int end) {
        if (end == left) {
            return null;
        }
        int maxIndex = left;
        int rootValue = nums[maxIndex];
        for (int i = left; i < end; i++) {
            if (rootValue < nums[i]) {
                maxIndex = i;
                rootValue = nums[maxIndex];
            }
        }
        TreeNode node = new TreeNode(rootValue);

        // 找到了 开始分割
        if (end - left == 1) {
            return node;
        }
        node.left = buildTree(nums, left, maxIndex);
        node.right = buildTree(nums, maxIndex + 1, end);
        return node;
    }
}
