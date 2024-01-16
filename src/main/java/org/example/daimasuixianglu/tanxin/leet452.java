package org.example.daimasuixianglu.tanxin;

import java.util.Arrays;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description
 * @date 2024/1/14 18:35:39
 */
public class leet452 {

    public int findMinArrowShots(int[][] points) {
        // 对points排序
        // left right
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
        int right = points[0][1];
        int result = 1;
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > right) {
                result++;
                right = points[i][1];
            } else {
                right = Math.min(right, points[i][1]);
            }
        }
        return result;
    }
}
