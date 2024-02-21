package org.example.daimasuixianglu.huisu;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description
 * @date 2024/1/10 20:26:19
 */
public class leet491 {
    @Test
    public void test() {
        System.out.println(findSubsequences(new int[]{4, 7, 6, 7}));
    }

    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        backtracking(nums, result, temp, 0);
        return result;
    }

    private void backtracking(int[] nums, List<List<Integer>> result, List<Integer> temp, int index) {
        if (temp.size() >= 2) {
            result.add(new ArrayList<>(temp));
        }
        HashSet<Integer> hs = new HashSet<>();
        for (int i = index; i < nums.length; i++) {
            if (!temp.isEmpty() && nums[i] < temp.get(temp.size() - 1)) {
                continue;
            }
            boolean isReapt = false;
            for (int j = index; j < i; j++) {
                if (nums[j] == nums[i]) {
                    isReapt = true;
                }
            }
            if (i > index && isReapt){
                continue;
            }
            temp.add(nums[i]);
            backtracking(nums, result, temp, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}
