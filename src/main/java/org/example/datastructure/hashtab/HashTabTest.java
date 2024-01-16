package org.example.datastructure.hashtab;


import org.junit.Test;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description 数据+链表的 哈希表实现
 * @date 2023/12/9 23:15:56
 */
public class HashTabTest {

    /**
     * 测试添加和打印
     */
    @Test
    public void test1() {
        HashTab hashtable = new HashTab(7);
        hashtable.list();
        hashtable.add(new Emp(1, "小明"));
        hashtable.add(new Emp(2, "小红"));
        hashtable.add(new Emp(3, "小蓝"));
        System.out.println("");
        hashtable.list();
        hashtable.add(new Emp(3, "小蓝"));
        hashtable.add(new Emp(4, "小蓝4"));
        hashtable.add(new Emp(5, "小蓝5"));
        hashtable.add(new Emp(6, "小蓝6"));
        hashtable.add(new Emp(7, "小蓝7"));
        hashtable.add(new Emp(8, "小蓝8"));
        hashtable.add(new Emp(9, "小蓝9"));
        System.out.println("");
        hashtable.list();

    }

}


class Emp {
    public int id;
    public String name;
    public Emp next;
    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

/**
 * 链表类
 */
class EmpLinkedList {
    // 直接保存头节点
    private Emp head;

    public void add(Emp emp) {
        if (head == null) {
            head = emp;
            return;
        }
        Emp temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp.next = emp;
        }
        temp.next = emp;
    }

    /**
     * 打印链表元素
     *
     * @param no
     */
    public void list(int no) {
        if (head == null) {
            System.out.println("链表为空");
            return;
        }
        Emp temp = head;
        while (true) {
            System.out.printf("%d : \t id=%d,\t name=%s \n", no, temp.id, temp.name);
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
    }

    public Emp findById(int id) {
        if (head == null) {
            return null;
        }
        Emp temp = head;
        while (true) {
            if (temp.id == id) {
                break;
            }
            if (temp.next == null) {
                temp = null;
                break;
            }
            temp = temp.next;
        }
        return temp;
    }

    public Emp deleteById(int id) {
        if (head == null) {
            return null;
        }
        Emp temp = head;
        Emp prev = head;
        while (true) {
            if (temp.id == id) {
                break;
            }
            if (temp.next == null) {
                // 当下一个为空的时候，则表示没有找到
                temp = null;
                break;
            }
            prev = temp;  // 标记上一个雇员
            temp = temp.next;
        }
        // 没有找到
        if (temp == null) {
            return null;
        }
        if (temp == head) {
            head = temp.next;
            return temp;
        }

        prev.next = temp.next;
        return temp;
    }
}

class HashTab {
    // 链表数组
    private EmpLinkedList[] linkedArray;
    private int size;

    public HashTab(int size) {
        this.linkedArray = new EmpLinkedList[size];
        this.size = size;
        for (int i = 0; i < size; i++) {
            linkedArray[i] = new EmpLinkedList();
        }
    }

    /**
     * 往哈希表中添加一个员工
     *
     * @param emp
     */
    public void add(Emp emp) {
        // 首先需要确定：该员工的 id 所在的哈希位置，用散列函数来计算
        int id = emp.id;
        int index = hashFun(id);
        linkedArray[index].add(emp);
    }

    /**
     * 打印哈希表
     */
    public void list() {
        for (int i = 0; i < size; i++) {
            linkedArray[i].list(i);
        }
    }

    /**
     * 散列函数
     *
     * @param id
     * @return
     */
    private int hashFun(int id) {
        // 散列函数的计算法方法有很多种
        // 这里就使用最简单的取模
        return id % size;
    }
}