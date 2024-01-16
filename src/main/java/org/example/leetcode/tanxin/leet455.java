package org.example.leetcode.tanxin;

import java.util.Arrays;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description
 * @date 2023/12/26 19:52:31
 */
public class leet455 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int p = 0;
        int q = 0;
        while (p < g.length && q < s.length) {
            if (g[p] <= s[q]) {
                p++;
            }
            q++;
        }
        return p;
    }
}
