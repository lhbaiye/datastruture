package org.example.datastructure.tree;

import org.junit.Test;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description 二叉树测试
 * @date 2023/12/10 12:53:04
 */
public class BinaryTreeTest {

    // 编写二叉树对象

    /**
     * 前、中、后 遍历测试
     */
    @Test
    public void fun1() {
        // 创建节点与构建二叉树
        HeroNode n1 = new HeroNode(1, "宋江");
        HeroNode n2 = new HeroNode(2, "无用");
        HeroNode n3 = new HeroNode(3, "卢俊");
        HeroNode n4 = new HeroNode(4, "林冲");
        n1.left = n2;
        n1.right = n3;
        n3.right = n4;
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.root = n1;

        System.out.println("\n 前序遍历：");
        binaryTree.preOrder();
        System.out.println("\n 中序遍历：");
        binaryTree.infixOrder();
        System.out.println("\n 后序遍历：");
        binaryTree.postOrder();
    }


    class HeroNode {
        public int id;
        public String name;
        public HeroNode left;
        public HeroNode right;

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
        /**
         * 前序遍历，先遍历根节点，然后左子节点，然后右子节点
         */
        public void preOrder() {
            System.out.println(this);
            if (this.left != null) {
                this.left.preOrder();
            }
            if (this.right != null) {
                this.left.preOrder();
            }
        }

        public void infixOrder() {
            if (this.left != null) {
                this.left.infixOrder();
            }
            System.out.println(this);
            // 3. 如果右子节点不为空，则递归继续前序遍历
            if (this.right != null) {
                this.right.infixOrder();
            }
        }

        /**
         * 后序遍历
         */
        public void postOrder() {
            // 1. 如果左子节点不为空，则递归继续前序遍历
            if (this.left != null) {
                this.left.postOrder();
            }
            // 2. 如果右子节点不为空，则递归继续前序遍历
            if (this.right != null) {
                this.right.postOrder();
            }
            // 3. 先输出当前节点
            System.out.println(this);
        }

        public HeroNode preOrderSearch(int id) {
            System.out.println(" 进入前序遍历");
            HeroNode result = null;
            if (this.id == id) {
                return this;
            }
            // 如果左子树不为空，递归遍历
            if (this.left != null) {
                result = this.left.preOrderSearch(id);
                if (result != null) {
                    return result;
                }
            }
            if (this.right != null) {
                result = this.right.preOrderSearch(id);
                if (result != null) {
                    return result;
                }
            }
            return result;
        }

        public HeroNode infixOrderSearch(int id) {
            if (this.left != null) {
                HeroNode result = this.left.infixOrderSearch(id);
                if (result != null) {
                    return result;
                }
            }
            System.out.println("进入中序遍历");
            if (this.id == id) {
                return this;
            }

            if (this.right != null) {
                HeroNode result = this.right.infixOrderSearch(id);
                if (result != null) {
                    return result;
                }
            }
            return null;
        }
        public HeroNode postOrderSearch(int id) {
//            System.out.println("  进入后序遍历");  // 用来统计查找了几次，不能在这里打印，这里打印是进入了方法几次，看的是比较了几次
            // 1. 如果左子节点不为空，则递归继续前序遍历
            if (this.left != null) {
                HeroNode result = this.left.postOrderSearch(id);
                if (result != null) {
                    return result;
                }
            }
            // 2. 如果右子节点不为空，则递归继续前序遍历
            if (this.right != null) {
                HeroNode result = this.right.postOrderSearch(id);
                if (result != null) {
                    return result;
                }
            }
            System.out.println("  进入后序遍历");
            // 3. 如果相等，则返回
            if (this.id == id) {
                return this;
            }
            return null;
        }

        /**
         * 删除节点，老师的思路写法，先看左右，看完再递归
         * @param id
         * @return 如果删除成功，则返回删除的节点
         */
        public HeroNode delete(int id) {
            HeroNode target = null;
            // 判断左子节点是否为要被删除的节点
            if (this.left != null && this.left.id == id) {
                target = this.left;
                this.left = null;
                return target;
            }
            if (this.right != null && this.right.id == id) {
                target = this.right;
                this.right = null;
                return target;
            }

            // 尝试左递归
            if (this.left != null) {
                target = this.left.delete(id);
                if (target != null) {
                    return target;
                }
            }
            // 尝试右递归
            if (this.right != null) {
                target = this.right.delete(id);
                if (target != null) {
                    return target;
                }
            }
            return null;
        }

        /**
         * 删除节点，考虑子节点
         * 1. 如果该非叶子节点 A 只有一个 **子节点 B**，则子 **节点 B 替代节点 A**
         * 2. 如果该非叶子节点 A 有 **左子节点 B** 和 **右子节点 C**，则让 **左子节点 B 替代节点 A**
         *
         * @param id
         * @return
         */
        public HeroNode deleteV2(int id) {
            HeroNode target = null;
            // 判断左子节点是否又要删除的点
            if (this.left != null && this.left.id == id) {
                target = this.left;
                // 如果当前删除的节点是叶子节点，直接删除
                if (this.left.left == null && this.left.right == null) {
                    this.left = null;
                    return target;
                }
                // 如果有两个子节点,则让左子节点替代该节点
                if (this.left.left != null && this.left.right != null) {
                    this.left = this.left.left;
                    return target;
                }
                // 如果只有一个子节点，则子节点替代该节点
                if (this.left.left != null) {
                    this.left = this.left.left;
                    return target;
                }

                if (this.left.right != null) {
                    this.left = this.left.right;
                    return target;
                }
                return target;
            }
            if (this.right != null && this.right.id == id) {
                target = this.right;
                // 如果当前删除的节点就是叶子节点，则直接删除
                if (right.left == null && right.right == null) {
                    this.right = null;
                    return target;
                }
                // 如果有两个子节点,则让左子节点替代该节点
                if (right.left != null && right.right != null) {
                    right = right.left;
                    return target;
                }
                // 如果只有一个子节点，则子节点替代该节点
                if (right.left != null) {
                    right = right.left;
                    return target;
                }

                if (right.right != null) {
                    right = right.right;
                    return target;
                }
                return target;
            }
            // 开始递归
            if (this.left != null) {
                target = this.left.deleteV2(id);
                if (target != null) {
                    return target;
                }
            }
            if (this.right != null) {
                target = this.right.deleteV2(id);
                if (target != null) {
                    return target;
                }
            }
            return null;
        }
    }

    class BinaryTree {
        public HeroNode root;

        /**
         * 前序遍历
         */
        public void preOrder() {
            if (root == null) {
                System.out.println("二叉树为空");
                return;
            }
            root.preOrder();
        }

        /**
         * 中序遍历
         */
        public void infixOrder() {
            if (root == null) {
                System.out.println("二叉树为空");
                return;
            }
            root.infixOrder();
        }

        /**
         * 后续遍历
         */
        public void postOrder() {
            if (root == null) {
                System.out.println("二叉树为空");
                return;
            }
            root.postOrder();
        }

        /**
         * 前序查找
         */
        public HeroNode preOrderSearch(int id) {
            if (root == null) {
                System.out.println("二叉树为空");
                return null;
            }
            return root.preOrderSearch(id);
        }

        /**
         * 中序查找
         */
        public HeroNode infixOrderSearch(int id) {
            if (root == null) {
                System.out.println("二叉树为空");
                return null;
            }
            return root.infixOrderSearch(id);
        }

        /**
         * 后序查找
         */
        public HeroNode postOrderSearch(int id) {
            if (root == null) {
                System.out.println("二叉树为空");
                return null;
            }
            return root.postOrderSearch(id);
        }

        public HeroNode delete(int id) {
            if (root == null) {
                System.out.println("树为空");
                return null;
            }
            HeroNode target = null;
            if (root.id == id) {
                target = root;
                root = null;
            } else {
                target = this.root.delete(id);
            }
            return target;
        }

        public HeroNode deleteV2(int id) {
            if (root == null) {
                System.out.println("树为空");
            }
            HeroNode target = null;
            if (root.id == id) {
                target = root;
                // 如果当前删除的节点就是叶子节点，则直接删除
                if (root.left == null && root.right == null) {
                    root = null;
                    return target;
                }
                // 如果有两个子节点,则让左子节点替代该节点
                if (root.left != null && root.right != null) {
                    root = root.left;
                    return target;
                }
                // 如果只有一个子节点，则子节点替代该节点
                if (root.left != null) {
                    root = root.left;
                    return target;
                }

                if (root.right != null) {
                    root = root.right;
                    return target;
                }
            } else {
                target = this.root.deleteV2(id);
            }
            return target;
        }
    }

    /**
     * 查找 id=5 的前、中、后序测试
     */
    @Test
    public void fun3() {
        // 创建节点与构建二叉树
        HeroNode n1 = new HeroNode(1, "宋江");
        HeroNode n2 = new HeroNode(2, "无用");
        HeroNode n3 = new HeroNode(3, "卢俊");
        HeroNode n4 = new HeroNode(4, "林冲");
        HeroNode n5 = new HeroNode(5, "关胜");
        n1.left = n2;
        n1.right = n3;
        n3.right = n4;
        n3.left = n5;
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.root = n1;

        System.out.println("找到测试：");
        int id = 5;
        System.out.println("\n前序遍历查找 id=" + id);
        System.out.println(binaryTree.preOrderSearch(id));
        System.out.println("\n中序遍历查找 id=" + id);
        System.out.println(binaryTree.infixOrderSearch(id));
        System.out.println("\n后序遍历查找 id=" + id);
        System.out.println(binaryTree.postOrderSearch(id));

        System.out.println("找不到测试：");
        id = 15;
        System.out.println("\n前序遍历查找 id=" + id);
        System.out.println(binaryTree.preOrderSearch(id));
        System.out.println("\n中序遍历查找 id=" + id);
        System.out.println(binaryTree.infixOrderSearch(id));
        System.out.println("\n后序遍历查找 id=" + id);
        System.out.println(binaryTree.postOrderSearch(id));
    }
}
