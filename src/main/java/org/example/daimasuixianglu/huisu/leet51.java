package org.example.daimasuixianglu.huisu;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description
 * @date 2024/1/11 13:34:48
 */
public class leet51 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        int[] temp = new int[n];
        backtracking(n, result, temp, 0);
        return result;
    }

    private void backtracking(int n, List<List<String>> result, int[] temp, int index) {
        if (index == n) {
            ArrayList<String> strings = new ArrayList<>();
//            result.add(new ArrayList<>(temp));
            for (int i = 0; i < temp.length; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if (j != temp[i]) {
                        sb.append('.');
                    } else {
                        sb.append("Q");
                    }
                }
                strings.add(sb.toString());
            }
            result.add(strings);
            return;
        }
        for (int i = 0; i < n; i++) {
            // 判断是否可以加入
            temp[index] = i;
            if (judge(temp, index)) {
                backtracking(n, result, temp, index + 1);
            }
        }
    }

    private boolean judge(int[] temp, int index) {
        for (int i = 0; i < index; i++) {
            if (temp[i] == temp[index] || Math.abs(index - i) == Math.abs(temp[index] - temp[i])) {
                return false;
            }
        }
        return true;
    }
}
