package org.example.daimasuixianglu.huisu;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description
 * @date 2024/1/10 21:19:58
 */
public class leet47 {

    @Test
    public void test() {
        System.out.println(permuteUnique(new int[]{1, 1, 2}));;
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        backtracking(nums, result, temp, used);
        return result;
    }

    private void backtracking(int[] nums, List<List<Integer>> result, List<Integer> temp, boolean[] used) {
        if (temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && !used[i - 1] && nums[i] == nums[i -1]) {
                continue;
            }
            if (used[i]) {
                continue;
            }
            temp.add(nums[i]);
            used[i] = true;
            backtracking(nums, result, temp, used);
            temp.remove(temp.size() - 1);
            used[i] = false;
        }
    }
}
