package org.example.daimasuixianglu.tanxin;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description
 * @date 2024/1/14 19:21:22
 */
public class leet56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        Deque<int[]> queue = new LinkedList<>();
        queue.addLast(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] temp = queue.peekLast();
            if (temp[1] >= intervals[i][0]) {
                queue.pollLast();
                queue.addLast(new int[]{temp[0], Math.max(intervals[i][1], temp[1])});
            } else {
                queue.addLast(intervals[i]);
            }
        }
        // 获取行数和列数
        int rowCount = queue.size();
        int columnCount = queue.peekFirst().length;

        // 创建二维数组
        int[][] array = new int[rowCount][columnCount];

        // 复制元素到二维数组
        int rowIndex = 0;
        for (int[] row : queue) {
            System.arraycopy(row, 0, array[rowIndex], 0, columnCount);
            rowIndex++;
        }
        return queue.toArray(new int[queue.size()][]);

    }
}
