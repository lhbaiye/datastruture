package org.example.leetcode.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * @date 2023/12/25 12:31:01
 */
public class leet46 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        leet46 leet46 = new leet46();
        System.out.println(leet46.permute(nums));
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subSet = new ArrayList<>();
        // 标记这个元素是否已经添加到结果集
        boolean[] visited = new boolean[nums.length];
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
            subSet.add(nums[i]);
            visited[i] = true;
            backtrack(nums, visited, subSet, result);
            subSet.remove(subSet.size() - 1);
            visited[i] = false;
        }
    }
}
