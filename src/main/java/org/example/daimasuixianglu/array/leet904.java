package org.example.daimasuixianglu.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description
 * @date 2024/1/11 18:40:18
 */
public class leet904 {
    public int totalFruit(int[] fruits) {
        int res = Integer.MIN_VALUE;
        Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();
        int l = 0;

        for (int r = 0; r < fruits.length; r++) {
            cnt.put(fruits[r], cnt.getOrDefault(fruits[r], 0) + 1);
            while (cnt.size() > 2) {
                cnt.put(fruits[l], cnt.get(fruits[l]) - 1);
                if (cnt.get(fruits[l]) == 0) {
                    cnt.remove(fruits[l]);
                }
                l++;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}
