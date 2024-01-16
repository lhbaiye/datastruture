package org.example.daimasuixianglu.tanxin;

import java.util.Arrays;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description
 * @date 2024/1/13 13:10:57
 */
public class leet455 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int gIndex = 0;
        int sIndex = 0;
        while (gIndex < g.length && sIndex < s.length) {
            if (s[sIndex] >= g[gIndex]) {
                sIndex++;
                gIndex++;
            } else {
                sIndex++;
            }
        }
        return gIndex;
    }
}
