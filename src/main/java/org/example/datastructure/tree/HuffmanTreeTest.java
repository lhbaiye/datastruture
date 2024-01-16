//package org.example.datastructure.tree;
//
//import org.junit.Test;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//
///**
// * @author chenxuyang
// * @version 1.0
// * @project untitled
// * @description 赫夫曼树
// * @date 2023/12/12 19:38:39
// */
//public class HuffmanTreeTest {
//    @Test
//    public void processDemo() {
//        int[] arr = {13, 7, 8, 3, 29, 6, 1};
//        // 1. 为了实现方便，先将每个元素转成 Node 对象，并装入 arrayList 中
//        List<Node> nodes = new ArrayList<>();
//        for (int i : arr) {
//            nodes.add(new Node(i));
//        }
//        Collections.sort(nodes);
//        // 3. 取出两个较小的树
//        Node left = nodes.get(0);
//        Node right = nodes.get(1);
//        // 4. 构成成新的二叉树
//        Node parent = new Node(left.value + right.value);
//        parent.left = left;
//        parent.right = right;
//        // 5. 从 list 中删除已经处理过的二叉树
//        nodes.remove(left);
//        nodes.remove(right);
//        // 6. 将新的二叉树添加到 list 中，为下一轮构建做准备
//        nodes.add(parent);
//
//    }
//
//    public Node createHuffmanTree(int[] arr) {
//        List<Node> nodes = new ArrayList<>();
//        for (int i : arr) {
//            nodes.add(new Node(i));
//        }
//        while (nodes.size() > 1) {
//            Collections.sort(nodes);
//            Node left = nodes.get(0);
//            Node right = nodes.get(1);
//            Node parent = new Node(left.value + right.value);
//            parent.left = left;
//            parent.right = right;
//            // 5. 从 list 中删除已经处理过的二叉树
//            nodes.remove(left);
//            nodes.remove(right);
//            nodes.add(parent);
//        }
//        return nodes.get(0);
//    }
//}
//
//
//class Node implements Comparable<Node> {
//    int value;
//    Node left;
//    Node right;
//    public Node(int value) {
//        this.value = value;
//    }
//    /**
//     * 为了打印方便
//     *
//     * @return
//     */
//    @Override
//    public String toString() {
//        return value + "";
//    }
//
//    /**
//     * 从小到大排序
//     * @param o the object to be compared.
//     * @return
//     */
//    @Override
//    public int compareTo(Node o) {
//        return this.value - o.value;
//    }
//}