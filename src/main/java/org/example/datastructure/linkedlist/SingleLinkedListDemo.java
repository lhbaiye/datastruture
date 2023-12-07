package org.example.datastructure.linkedlist;

import java.util.Stack;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description 单向链表测试
 * @date 2023/12/6 22:32:29
 */
public class SingleLinkedListDemo {

    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.add(hero1);
        singleLinkedList.add(hero2);
        singleLinkedList.add(hero3);
        singleLinkedList.add(hero4);

        singleLinkedList.list();
    }

}

class SingleLinkedList {
    // 头节点，不保存任何数据，只是用来作为一个起始点
    private HeroNode head = new HeroNode(0, "", "");

    public void add(HeroNode node) {
        // 遍历到next为null的时候，才可以添加
        HeroNode temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = node;
    }

    public void list() {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head;
        while (temp.next != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }

    public void addByOrder(HeroNode node) {
        // 由于 head 变量不能动，动了就无法从头遍历了，使用辅助变量来完成我们的添加
        HeroNode temp = head;
        boolean exist = false;  // 添加的节点是否已经在链表中存在
        while (true) {
            if (temp.next == null) {
                break;
            }
            // 如果当前节点编号大于目标节点，则找到，
            if (temp.next.no > node.no) {
                break;
            }

            if (temp.next.no == node.no) {
                exist = true;
                break;
            }
            // 没找到，则后移 temp ，继续寻找
            temp = temp.next;
        }
        if (exist) {
            System.out.printf("准备插入的英雄编号 %d 已经存在，不能加入 \n", node.no);
            return;
        }
        node.next = temp.next;
        temp.next = node;
    }

    public void update(HeroNode newNode) {
        if (head.next == null) {
            System.out.println("链表空");
            return;
        }
        HeroNode temp = head;
        boolean exist = false;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == newNode.no) {
                exist = true;
                break;
            }
            temp = temp.next;
        }
        if (exist) {
            temp.name = newNode.name;
            temp.nickName = newNode.nickName;
        } else {
            System.out.printf("未找到编号为 %d 的英雄", newNode.no);
        }
    }

    public void delete(int no) {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head;
        boolean exist = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no == no) {
                exist = true;
                break;
            }
            temp = temp.next;
        }
        if (!exist) {
            System.out.printf("未找到编号 %d \n", no);
        }
        temp.next = temp.next.next;
    }
    public void reverse() {
        if (head.next == null) {
            return;
        }
        HeroNode cur = head.next;
        HeroNode next = null;
        HeroNode reverseNode = new HeroNode(0, "", "");
        while (cur != null) {
            next = cur.next;
            cur.next = reverseNode.next;
            reverseNode.next = cur;
            cur = next;
        }
        head.next = reverseNode.next;
    }

    public void reversePrint() {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        Stack<HeroNode> stack = new Stack<>();
        HeroNode cur = head.next;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        while (!stack.empty()) {
            System.out.println(stack.pop());
        }
    }
}

class HeroNode {
    public int no;
    public String name;
    public String nickName;
    public HeroNode next;

    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
