package org.example.leetcode.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description
 * @date 2023/12/25 12:59:54
 */
public class leet39 {
    public static void main(String[] args) {
        leet39 leet39 = new leet39();
        int[] nums = {2,3,6,7};
        System.out.println(leet39.combinationSum(nums, 7));
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subSet = new ArrayList<>();
        // 标记这个元素是否已经添加到结果集
        Arrays.sort(candidates);
        backtrack(candidates, 0, target, subSet, result);
        return result;
    }

    private void backtrack(int[] candidates, int pos, int target, List<Integer> subSet, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(subSet));
            return;
        }
        if (target < 0) {
            return;
        }
        // 开始
        for (int i = pos; i < candidates.length; i++) {
            subSet.add(candidates[i]);
            target = target - candidates[i];
            backtrack(candidates, i, target, subSet, result);
            subSet.remove(subSet.size() - 1);
            target+=candidates[i];
        }
    }

}
