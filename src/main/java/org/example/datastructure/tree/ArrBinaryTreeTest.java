package org.example.datastructure.tree;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description 顺序存储二叉树
 * @date 2023/12/10 15:11:44
 */
public class ArrBinaryTreeTest {

}


class ArrBinaryTree {
    public int[] arr;

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }

    /**
     * 前序遍历
     *
     * @param index 就是知识点中的 n,从哪一个节点开始遍历
     */
    public void preOrder(int index) {
        /**
         * 1. 顺序二叉树，通常只考虑完全二叉树
         * 2. 第n个元素的左子节点为 2n+1
         * 3. 第n个元素的右子节点为 2n+2
         * 4. 第n个元素的父节点为 (n-1)/2
         */
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空");
            return;
        }
        // 先输出当前节点，因为当前节点就是root节点
        System.out.println(arr[index]);
        int left = 2 * index + 1;
        if (left < arr.length) {
            preOrder(left);
        }
        int right = 2 * index + 2;
        if (right < arr.length) {
            preOrder(right);
        }
    }

    public void infixOrder(int index) {
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空");
            return;
        }
        int left = 2 * index + 1;
        if (left < arr.length) {
            infixOrder(left);
        }
        System.out.println(arr[index]);
        int right = 2 * index + 2;
        if (right < arr.length) {
            infixOrder(right);
        }
    }

    /**
     * 后序遍历：先遍历左子树，再遍历右子树，最后输出父节点
     *
     * @param index
     */
    public void postOrder(int index) {
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空，不能前序遍历二叉树");
            return;
        }
        int left = 2 * index + 1;
        if (left < arr.length) {
            postOrder(left);
        }
        int right = 2 * index + 2;
        if (right < arr.length) {
            postOrder(right);
        }
        System.out.println(arr[index]);
    }

}
