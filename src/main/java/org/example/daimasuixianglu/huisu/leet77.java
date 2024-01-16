package org.example.daimasuixianglu.huisu;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description
 * @date 2024/1/9 14:52:45
 */
public class leet77 {

    @Test
    public void test(){
        List<List<Integer>> combine = combine(4, 2);
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        backtracking(n, k, result, temp, 1);
        return result;
    }
    public void backtracking(int n, int k, List<List<Integer>> result, List<Integer> temp, int startIndex) {
        if (temp.size() == k) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = startIndex; i <= n; i++) {
            temp.add(i);
            backtracking(n, k, result, temp, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}
