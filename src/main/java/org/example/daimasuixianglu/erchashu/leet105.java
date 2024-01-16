package org.example.daimasuixianglu.erchashu;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description
 * @date 2024/1/7 16:28:53
 */
public class leet105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        return buildTree(inorder, 0, inorder.length, preorder, 0, preorder.length);
    }

    public TreeNode buildTree(int[] inorder, int leftIn, int rightIn, int[] preorder, int leftPre, int rightPre) {
        if (rightIn - leftIn == 0) {
            return null;
        }
        int rootVal = preorder[leftPre];
        TreeNode root = new TreeNode(rootVal);
        if (rightPre - leftPre == 1) {
            return root;
        }
        // 找中点
        int middleIndex;
        for (middleIndex = leftIn; middleIndex < rightIn; middleIndex++) {
            if (inorder[middleIndex] == rootVal) {
                break;
            }
        }
        // 分割
        int leftInorderStart = leftIn;
        int leftInorderEnd = middleIndex;
        int rightInorderStart = middleIndex + 1;
        int rightInorderEnd = rightIn;

        int leftPreorderStart = leftPre + 1;
        int leftPreorderEnd = leftPreorderStart + (leftInorderEnd - leftInorderStart);
        int rightPreorderStart = leftPreorderEnd;
        int rightPreorderEnd = rightPre;
        root.left = buildTree(inorder, leftInorderStart, leftInorderEnd, preorder, leftPreorderStart, leftPreorderEnd);
        root.right = buildTree(inorder, rightInorderStart, rightInorderEnd, preorder, rightPreorderStart, rightPreorderEnd);
        return root;
    }
}
