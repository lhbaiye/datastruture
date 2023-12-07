package org.example.datastructure.josepfu;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description 环形链表
 * @date 2023/12/7 19:41:39
 */
public class CircleSingleLinkedList {
    Boy first = null;

    public void add(int nums) {
        if (nums < 1) {
            System.out.println("至少添加一个");
            return;
        }
        Boy cur = null;
        for (int i = 0; i < nums; i++) {
            Boy boy = new Boy(i);
            if (first == null) {
                first = boy;
                boy.next = first;
                cur = first;
                continue;
            }
            cur.next = boy;
            boy.next = first;
            cur = boy;
        }
    }

    /**
     * 打印队列
     */
    public void print() {
        if (first == null) {
            System.out.println("队列为空");
            return;
        }
        Boy cur = first;
        while (true) {
            System.out.printf("小孩编号 %d \n", cur.no);
            cur = cur.next;
            // 如果和 first 一致，则标识已经走了一圈了
            if (cur == first) {
                return;
            }
        }
    }

    /**
     * 游戏开始，计算出圈顺序
     *
     * @param startNo  从第几个小孩开始数
     * @param countNum 数几下
     * @param nums     参与该游戏的小孩有多少个
     */
    public void countBoy(int startNo, int countNum, int nums) {
        if (first == null || countNum < 1 || startNo > nums) {
            System.out.println("参数有误");
        }
        //1.初始化辅助变量,first 的后面
        Boy helper = first;
        while (helper.next != first) {
            helper = helper.next;
        }
        //2. 定位first和helper到startNo位置
        for (int i = 0; i < startNo - 1; i++) {
            helper = first;
            first = first.next;
        }
        // 为了测试方便，这里添加一个日志输出
        System.out.printf("定位到位置： %d \n", startNo);
        print();

        while (true) {
            //当队列只有一个元素，停止
            while (helper == first) {
                break;
            }
            for (int i = 0; i < countNum - 1; i++) {
                // 因为 helper 永远在 first 后面，只要在 first 移动时，指向 first 原来所在的位置即可
                helper = first;
                first = first.next;
            }
            System.out.printf("出圈小孩编号 %d \n", first.no);
            first = first.next;
            helper.next = first;
        }


    }


}


class Boy {
    int no;
    Boy next;

    public Boy(int no) {
        this.no = no;
    }
}