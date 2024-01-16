package org.example.daimasuixianglu.tanxin;

import java.util.Arrays;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description
 * @date 2024/1/14 18:59:23
 */
public class leet435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int result = 0;
        int right = intervals[0][1];
        int left = intervals[0][0];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= right) {
                right = intervals[i][1];
            } else {
                result++;
                right = Math.min(intervals[i][1], right);
            }
        }
        return result;
    }
}
