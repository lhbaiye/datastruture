package org.example.daimasuixianglu.tanxin;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description
 * @date 2024/1/14 18:19:19
 */
public class leet406 {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return b[0] - a[0];
        });
        LinkedList<int[]> que = new LinkedList<>();
        for (int[] p : people) {
            que.add(p[1], p);
        }
        return que.toArray(new int[people.length][]);
    }
}
