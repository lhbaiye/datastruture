package org.example.algorithm.dac;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description 汉诺塔
 * @date 2023/12/13 16:06:06
 */
public class Hanoitower {
    /**
     * 汉诺塔算法
     *
     * @param num 有几个盘子
     * @param a   a 柱子
     * @param b   b 柱子
     * @param c   c 柱子
     */
    public void hanoiTower(int num, char a, char b, char c) {
        //只有一个盘子时候
        if (num == 1) {
            System.out.printf("第 %d 个盘从 %s → %s \n", num, a, c);
        } else {
            // 否则堪称两个盘
            // 1. 最上面的 a- b
            // 最小规模是只有一个盘c，直接移动到c
            hanoiTower(num - 1, a, c, b);
            // 2. 最下面的盘：a -> c
            System.out.printf("第 %d 个盘从 %s → %s \n", num, a, c);
            hanoiTower(num - 1, b, a, c);
        }
    }
}
