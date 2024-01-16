package org.example.daimasuixianglu.huisu;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description
 * @date 2024/1/9 21:31:18
 */
public class leet78 {
    @Test
    public void test(){
        System.out.println(subsets(new int[]{1, 2, 3}));
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        backtracking(nums, result, temp, 0);
        return result;
    }

    private void backtracking(int[] nums, List<List<Integer>> result, List<Integer> temp, int index) {
        result.add(new ArrayList<>(temp));
        for (int i = index; i < nums.length; i++) {
            temp.add(nums[i]);
            backtracking(nums, result, temp, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}
