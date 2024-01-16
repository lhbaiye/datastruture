package org.example.leetcode.erjinzhi;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description
 * @date 2023/12/27 12:13:09
 */
public class leet190 {
    public int reverseBits(int n) {
        int result = 0;
        int p = 31;
        while (n != 0) {
            result += ((n & 1) << p);
            p--;
            n>>>=1;
        }
        return result;
    }
}
