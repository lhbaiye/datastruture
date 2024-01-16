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
 * @date 2024/1/10 20:04:37
 */
public class leet90 {

    @Test
    public void test(){
        subsetsWithDup(new int[] {1,2,2});
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(nums);
        backtracking(nums, result, temp, 0);
        return result;
    }

    private void backtracking(int[] nums, List<List<Integer>> result, List<Integer> temp, int index) {
        result.add(new ArrayList<>(temp));
        for (int i = index; i < nums.length; i++) {
            if (i != index && nums[i] == nums[i - 1]) {
                continue;
            }
            temp.add(nums[i]);
            backtracking(nums, result, temp, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}
