package org.example.leetcode.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 * @date 2023/12/25 12:45:06
 */
public class leet47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subSet = new ArrayList<>();
        // 标记这个元素是否已经添加到结果集
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(nums, visited, subSet, result);
        return result;

    }

    private void backtrack(int[] nums, boolean[] visited, List<Integer> subSet, List<List<Integer>> result) {
        if (subSet.size() == nums.length) {
            result.add(new ArrayList<>(subSet));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            if (i != 0 && nums[i] == nums[i - 1] && !visited[i-1]) {
                continue;
            }
            visited[i] = true;
            subSet.add(nums[i]);
            backtrack(nums, visited, subSet, result);
            visited[i] = false;
            subSet.remove(subSet.size() - 1);
        }
    }
}
