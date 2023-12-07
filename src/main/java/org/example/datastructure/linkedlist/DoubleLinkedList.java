package org.example.datastructure.linkedlist;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description 双向链表
 * @date 2023/12/7 12:44:55
 */
public class DoubleLinkedList {
    private DoubleLinkedNode head = new DoubleLinkedNode(0, "", "");
    public static void main(String[] args) {

    }
    public void add(DoubleLinkedNode node) {
        DoubleLinkedNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
        node.prev = temp;
    }

    public void update(DoubleLinkedNode newNode) {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        boolean exist = false;
        DoubleLinkedNode temp = head;
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
        // 如果已找到，则修改信息
        if (exist) {
            temp.name = newNode.name;
            temp.nickName = newNode.nickName;
        } else {
            System.out.printf("未找到编号为 %d 的英雄", newNode.no);
        }
    }

    public void delete(int no) {
        if (head.next == null) {
            return;
        }
        boolean exist = false;
        DoubleLinkedNode temp = head;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == no) {
                exist = true;
                break;
            }
            temp = temp.next;
        }
        if (!exist) {
            System.out.println("不存在");
        }
        if (temp.next != null) {
            temp.next.prev = temp.prev;
        }
        temp.prev.next = temp.next;
    }

    /**
     * 打印链表
     */
    public void print() {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        DoubleLinkedNode cur = head.next;
        while (cur != null) {
            System.out.println(cur);
            cur = cur.next;
        }
    }



}

class DoubleLinkedNode {
    public int no;
    public String name;
    public String nickName;
    public DoubleLinkedNode next;
    public DoubleLinkedNode prev;

    public DoubleLinkedNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    /**
     * 为了显示方便，重写
     *
     * @return
     */
    @Override
    public String toString() {
        return "DoubleLinkedNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
