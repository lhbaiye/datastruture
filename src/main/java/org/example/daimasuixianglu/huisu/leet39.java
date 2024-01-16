package org.example.daimasuixianglu.huisu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description
 * @date 2024/1/9 19:35:24
 */
public class leet39 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(candidates);
        backtracking(candidates, target, result, temp, 0);
        return result;
    }

    private void backtracking(int[] candidates, int target, List<List<Integer>> result, List<Integer> temp, int index) {
        if (target == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = index; i < candidates.length && candidates[i] <= target; i++) {
            temp.add(candidates[i]);
            backtracking(candidates, target - candidates[i], result, temp, i);
            temp.remove(temp.size() - 1);
        }

    }
}
