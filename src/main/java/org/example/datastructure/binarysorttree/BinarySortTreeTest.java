package org.example.datastructure.binarysorttree;


/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description 二叉排序树
 * @date 2023/12/12 20:56:33
 */
public class BinarySortTreeTest {

}

class BinarySortTree {
    Node root;

    /**
     * 添加节点
     *
     * @param node
     */
    public void add(Node node) {
        if (root == null) {
            root = node;
            return;
        }
        root.add(node);
    }

    /**
     * 中序遍历
     */
    public void infixOrder() {
        if (root == null) {
            return;
        }
        root.infixOrder();
    }

    /**
     * 查找目标节点
     *
     * @param value
     * @return
     */
    public Node searchTarget(int value) {
        if (root == null) {
            return null;
        }
        return root.searchTarget(value);
    }

    /**
     * 查找父节点
     *
     * @param value
     * @return
     */
    public Node searchParent(int value) {
        if (root == null) {
            return null;
        }
        if (root.value == value) {
            return null;
        }
        return root.searchParent(value);
    }

    /**
     * 删除节点
     * <pre>
     *   注意：删除节点的思路是找到 目标节点 和 父节点，利用这两个节点就可以完成删除了，
     *        而不是去递归查找的。这一点需要明白，而且很重要。否则你将不知道递归如何写
     * </pre>
     *
     * @param value
     */
    public void delete(int value) {
        if (root == null) {
            return;
        }
        Node target = searchTarget(value);
        if (target == null) {
            return;
        }
        // 如果找到了节点
        // 并且，root 没有子节点了，则说明当前只有 root 一个节点
        if (root.left == null && root.right == null) {
            root = null;
            return;
        }
        Node parent = searchParent(value);
        // 1. 如果目标节点是叶子节点
        if (target.left == null && target.right == null) {
            // 如果目标节点是 父节点的 左节点
            if (parent.left != null && target.value == parent.left.value) {
                parent.left = null;
                return;
            }
            // 如果目标节点是 父节点的 右节点
            if (parent.right != null && target.value == parent.right.value) {
                parent.right = null;
                return;
            }
        }
        // 2.如果目标节点有两个节点
        else if (target.left != null && target.right != null) {
            // 1. 以目标节点为 root 节点，找到左子树中最小的节点，并删掉；
            // 2. 并把目标节点使用这个最小节点替换掉
            //    可以有一个更简单的方式实现，删掉最小节点之后，直接将目标节点的 value 值替换为最小节点的值。  下面的实现没有采用替换值的方式，而是采用替换节点的方式，看起来就麻烦一点

            // 以目标节点为 root 节点，找到左子树中最小的节点，并删掉；也就是找到左子树中的一个 叶子节点
            Node min = deleteRightTreeMin(target);
            if (parent == root) {
                root = min;
                min.right = target.right;
                min.left = target.left;
                return;
            }
            // 如果是父节点的 左节点
            if (parent.left != null && target.value == parent.left.value) {
                parent.left = min;
                min.right = target.right;
                min.left = target.left;
                return;
            }
            // 如果是父节点的 右节点
            if (parent.right != null && target.value == parent.right.value) {
                parent.right = min;
                min.right = target.right;
                min.left = target.left;
                return;
            }
        } //3. 如果目标节点有 1 颗子节点
        else {
            // 如果删除的是 root 节点，全程不要操作 parent
            // 由于目标节点有一颗节点，先拿到这个要替换掉目标节点的  节点
            Node replaceNode = null;
            if (target.left != null) {
                replaceNode = target.left;
            } else {
                replaceNode = target.right;
            }
            // 如果要删除的是 root 节点
            if (parent == null) {
                root = replaceNode;
                return;
            }
            // 如果是父节点的 左节点
            if (parent.left != null && target.value == parent.left.value) {
                parent.left = replaceNode;
                return;
            }
            if (parent.right != null && target.value == parent.right.value) {
                parent.right = replaceNode;
            }
        }
        return;
    }

    /**
     * 以目标节点为 root 节点，找到左子树中最小的节点，并删掉；也就是找到左子树中的一个 叶子节点
     *
     * @param target
     * @return
     */
    private Node deleteRightTreeMin(Node target) {
        Node min = target.right;
        while (min.left != null) {
            min = min.left;
        }
        delete(min.value);
        return min;
    }
}

class Node {
    int value;
    Node left;
    Node right;
    public Node(int value) {
        this.value = value;
    }

    public int height() {
        return Math.max(
                (left == null ? 0 : left.height()),
                (right == null ? 0 : right.height())
        ) + 1;
    }

    public void leftRotate() {
        // 1.创建一个新的节点，newNode，值等于当前根节点的值
        Node newNode = new Node(value);
        newNode.left = left;
        newNode.right = right.left;
        value = right.value;
        left = newNode;
        right = right.right;
    }
    public void rightRotate() {
        Node newNode = new Node(value);
        newNode.right = right;
        newNode.left = left.right;
        value = left.value;
        left = left.left;
        right = newNode;
    }

    public void add(Node node) {
        if (node == null) {
            return;
        }
        if (node.value < value) {
            // 左节点为空，则直接挂在上面
            if (left == null) {
                left = node;
            } else {
                // 否则继续往下查找
                left.add(node);
            }
        } else {
            if (right == null) {
                right = node;
            } else {
                this.right.add(node);
            }
        }
    }

    /**
     * 中序遍历：刚好是从小到大的顺序
     */
    public void infixOrder() {
        if (left != null) {
            left.infixOrder();
        }
        System.out.println(value);
        if (right != null) {
            right.infixOrder();
        }
    }
    /**
     * 搜索目标节点
     *
     * @param value
     * @return
     */
    public Node searchTarget(int value) {
        if (value == this.value) {
            return this;
        } else if (value < this.value) {
            if (left != null) {
                return left.searchTarget(value);
            }
        } else {
            if (right != null) {
                return right.searchTarget(value);
            }
        }
        return null;
    }

    /**
     * 查找目标值的父节点
     *
     * @param value
     * @return
     */
    public Node searchParent(int value) {
        // 本节点能匹配到左右两节点其中一个等于，则父节点是本节点
        if (left != null && left.value == value || right != null && right.value == value) {
            return this;
        }
        if (left != null && value < this.value) {
            return left.searchParent(value);
        }
        if (value >= this.value && right != null) {
            return right.searchParent(value);
        }
        return null;
    }
}