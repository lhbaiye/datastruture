package org.example.daimasuixianglu.erchashu;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description
 * @date 2024/1/7 16:09:36
 */
public class leet106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0){
            return null;
        }
        return buildTree(inorder, 0, inorder.length, postorder, 0, postorder.length);
    }
    public TreeNode buildTree(int[] inorder, int leftIn, int rightIn, int[] postorder, int leftPost, int rightPost) {
        if (rightIn - leftIn == 0) {
            return null;
        }
        // 找到最后一个节点
        int rootVal = postorder[rightPost - 1];
        TreeNode root = new TreeNode(rootVal);
        if (rightPost - leftPost == 1) {
            return root;
        }
        // 分割
        int middleIndex = 0;
        for (middleIndex = leftIn; middleIndex < rightIn; middleIndex++) {
            if (inorder[middleIndex] == rootVal) {
                break;
            }
        }
        // 找到完以后分割
        int leftInorderStart = leftIn;
        int leftInorderEnd = middleIndex;
        int rightInorderStart = middleIndex + 1;
        int rightInorderEnd = rightIn;

        int leftPostOrderStart = leftPost;
        int leftPostOrderEnd = leftPost + (leftInorderEnd - leftInorderStart);
        int rightPostOrderStart = leftPostOrderEnd;
        int rightPostOrderEnd = rightPost - 1;
        root.left = buildTree(inorder, leftInorderStart, leftInorderEnd, postorder, leftPostOrderStart, leftPostOrderEnd);
        root.right = buildTree(inorder, rightInorderStart, rightInorderEnd, postorder, rightPostOrderStart, rightPostOrderEnd);
        return root;
    }

}
