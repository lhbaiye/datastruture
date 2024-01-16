package org.example.daimasuixianglu.dongtaiguihua;

import org.junit.Test;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description
 * @date 2024/1/16 14:37:32
 */
public class leet509 {

    @Test
    public void test() {
        System.out.println(fib(4));
    }
    public int fib(int n) {
        int a = 0;
        int b = 1;
        if (n == 0) {
            return a;
        }
        if (n == 1) {
            return b;
        }
        int res = 0;

        for (int i = 2; i <= n; i++) {
            res = a + b;
            a = b;
            b = res;
        }
        return res;
    }
}
