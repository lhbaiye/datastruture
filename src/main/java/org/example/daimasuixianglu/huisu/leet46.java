package org.example.daimasuixianglu.huisu;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description
 * @date 2024/1/10 21:06:33
 */
public class leet46 {

    @Test
    public void test() {
        System.out.println(permute(new int[]{1, 2, 3}));;
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtracking(nums, result, temp, used);
        return result;
    }

    private void backtracking(int[] nums, List<List<Integer>> result, List<Integer> temp, boolean[] used) {
        if (temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
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
