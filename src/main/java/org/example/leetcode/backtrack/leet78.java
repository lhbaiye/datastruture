package org.example.leetcode.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * @date 2023/12/25 12:11:53
 */
public class leet78 {
    public static void main(String[] args) {
        leet78 leet78 = new leet78();
    }
    public List<List<Integer>> subsets(int[] nums) {
        // 保存中间结果
        List<Integer> subSet = new ArrayList<>();
        // 保存最终结果
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, subSet, result);
        return result;
    }
    private void backtrack(int[] nums, int pos, List<Integer> subSet, List<List<Integer>> result) {
        result.add(new ArrayList<>(subSet));
        // 开始循环，
        for (int i = pos; i < nums.length; i++) {
            // 什么时候会跳过这个结果
            if (i != pos && nums[i] == nums[i - 1]) {
                continue;
            }
            subSet.add(nums[i]);
            backtrack(nums, i + 1, subSet, result);
            subSet.remove(subSet.size() - 1);
        }
    }
}
