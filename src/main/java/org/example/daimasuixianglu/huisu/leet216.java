package org.example.daimasuixianglu.huisu;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description
 * @date 2024/1/9 15:21:00
 */
public class leet216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        backtracking(n, k, result, temp, 1);
        return result;
    }

    private void backtracking(int n, int k, List<List<Integer>> result, List<Integer> temp, int startIndex) {
        if (n == 0 && temp.size() == k) {
            result.add(new ArrayList<>(temp));
            return;
        }
        if (n < 0 || temp.size() > k) {
            return;
        }
        for (int i = startIndex; i <= 9 - (k - temp.size()) + 1; i++) {
            temp.add(i);
            backtracking(n - i, k, result, temp, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}
