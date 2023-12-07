package org.example.datastructure.linkedlist;

import org.junit.Before;
import org.junit.Test;

public class DoubleLinkedListTest{

    DoubleLinkedList doubleLinkedList;

    @Before
    public void before() {
        DoubleLinkedNode hero1 = new DoubleLinkedNode(1, "宋江", "及时雨");
        DoubleLinkedNode hero2 = new DoubleLinkedNode(2, "卢俊义", "玉麒麟");
        DoubleLinkedNode hero3 = new DoubleLinkedNode(3, "吴用", "智多星");
        DoubleLinkedNode hero4 = new DoubleLinkedNode(4, "林冲", "豹子头");

        // 测试新增
        doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(hero1);
        doubleLinkedList.add(hero4);
        doubleLinkedList.add(hero2);
        doubleLinkedList.add(hero3);
    }

    /**
     * 更新测试
     */
    @Test
    public void updateTest() {
        System.out.println("更新前");
        doubleLinkedList.print();
        DoubleLinkedNode hero4New = new DoubleLinkedNode(4, "林冲-修改测试", "豹子头-修改测试");
        doubleLinkedList.update(hero4New);
        System.out.println("更新后");
        doubleLinkedList.print();
    }



}