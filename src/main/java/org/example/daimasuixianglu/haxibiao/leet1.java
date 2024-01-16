package org.example.daimasuixianglu.haxibiao;

import java.util.HashMap;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description
 * @date 2024/1/2 16:46:12
 */
public class leet1 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }
}
