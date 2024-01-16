package org.example.daimasuixianglu.array;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description
 * @date 2023/12/31 21:43:05
 */
public class leet69 {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        int l = 0, r = x - 1;
        while (l < r - 1) {
            int mid = l + (r - l) / 2;
            long res = (long) mid * mid;
            if (res == x) {
                return mid;
            } else if (res < x) {
                l = mid;
            } else {
                r = mid;
            }
        }
        if ((long) r * r < x) {
            return r;
        } else {
            return l;
        }
    }
}
