package org.example.daimasuixianglu.erchashu;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description
 * @date 2024/1/7 13:26:28
 */
public class leet257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        StringBuilder path = new StringBuilder();
        binaryTreePaths(root, result, path);
        return result;
    }

    public void binaryTreePaths(TreeNode root, List<String> result, StringBuilder sb) {
        if (root == null) {
            return;
        }
        sb.append(root.val);
        if (root.left == null && root.right == null) {
            result.add(sb.toString());
        } else {
            sb.append("->");
            if (root.left != null) {
                binaryTreePaths(root.left, result, new StringBuilder(sb));
            }
            if (root.right != null) {
                binaryTreePaths(root.right, result, new StringBuilder(sb));
            }
        }
    }
}
