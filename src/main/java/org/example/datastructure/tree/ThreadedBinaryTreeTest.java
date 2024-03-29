package org.example.datastructure.tree;

import org.junit.Test;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description 线索化二叉树
 * @date 2023/12/10 15:39:14
 */
public class ThreadedBinaryTreeTest {
    class HeroNode {
        public int id;
        public String name;
        public HeroNode left;
        public HeroNode right;
        /**
         * 左节点的类型：0：左子树，1：前驱节点
         */
        public int leftType;
        /**
         * 右节点的类型：0：右子树，1：后继节点
         */
        public int rightType;

        public HeroNode(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return "HeroNode{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    class ThreadedBinaryTree {
        public HeroNode root;
        public HeroNode pre; //保留上一个节点

        /**
         * 线索化二叉树：以 中序的方式线索化
         */
        public void threadeNodes() {
            // 从 root 开始遍历，然后 线索化
            this.threadeNodes(root);
        }

        public void threadeNodes(HeroNode node) {
            if (node == null) {
                return;
            }
            // 中序遍历的顺序 左 自己 右
            threadeNodes(node.left);
            // 如何线索化自己
            // 如果自己的left为空，则设置为前驱节点
            if (node.left == null) {
                node.left = pre;
                node.leftType = 1;
            }
            // 设置后继节点，只有回到自己的后继结点的时候，才能把自己设置为前一个的后继节点
            // 当前一个节点的 right 为空时，则需要自己是后继节点
            if (pre != null && pre.right == null) {
                pre.right = node;
                pre.rightType = 1;
            }

            // 数列： 1,3,6,8,10,14
            // 中序： 8,3,10,1,14,6
            // 这里最好结合图示的二叉树来看，容易理解
            // 因为中序遍历，先遍历左边，所以 8 是第一个输出的节点
            // 当 node = 8 时，pre 还没有被赋值过，则为空。这是正确的，因为 8 就是第一个节点
            // 当 8 处理完成之后，处理 3 时
            // 当 node = 3 时，pre 被赋值为 8 了。
            pre = node;
            threadeNodes(node.right);
        }

        public void threadedList() {
            // 前面线索化用的是中序，所以这里也用中序
            HeroNode node = root;
            while (node != null) {
                // 中序：左、自己、右
                // 数列： 1,3,6,8,10,14
                // 中序： 8,3,10,1,14,6
                // 那么先找到左边的第一个线索化节点，也就是 8. 对照图示理解，比较容易
                while (node.leftType == 0) {
                    node = node.left;
                }
                // 找到这个线索化节点，然后打印他
                System.out.println(node);
                // 如果该节点右子节点也是线索化节点，则打印它
                while (node.rightType == 1) {
                    node = node.right;
                    System.out.println(node);
                }
                // 到达这里，就说明遇到的不是一个 线索化节点了
                // 而且，按中序的顺序来看：这里应该处理右侧了
                node = node.right;
            }
        }

    }

    @Test
    public void threadeNodesTest() {
        HeroNode n1 = new HeroNode(1, "宋江");
        HeroNode n3 = new HeroNode(3, "无用");
        HeroNode n6 = new HeroNode(6, "卢俊");
        HeroNode n8 = new HeroNode(8, "林冲2");
        HeroNode n10 = new HeroNode(10, "林冲3");
        HeroNode n14 = new HeroNode(14, "林冲4");
        n1.left = n3;
        n1.right = n6;
        n3.left = n8;
        n3.right = n10;
        n6.left= n14;

        ThreadedBinaryTree tree = new ThreadedBinaryTree();
        tree.root = n1;

        tree.threadeNodes();

        // 验证：
        HeroNode left = n10.left;
        HeroNode right = n10.right;
        System.out.println("10 号节点的前驱节点：" + left.id);
        System.out.println("10 号节点的后继节点：" + right.id);
    }
}
