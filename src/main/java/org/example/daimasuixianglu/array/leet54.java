package org.example.daimasuixianglu.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description
 * @date 2024/1/1 14:25:39
 */
public class leet54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        List<Integer> res = new ArrayList<>();
        int u = 0, d = m - 1, l = 0, r = n - 1;
        while (true) {
            for (int i = l; i <= r; i ++) res.add(matrix[u][i]);
            if (++u > d) break;
            for (int i = u; i <= d; i ++) res.add(matrix[i][r]);
            if (--r < l) break;
            for (int i = r; i >= l; i --) res.add(matrix[d][i]);
            if (--d < u) break;
            for (int i = d; i  >= u; i --) res.add(matrix[i][l]);
            if (++l > r) break;
        }
        return res;
    }
}
