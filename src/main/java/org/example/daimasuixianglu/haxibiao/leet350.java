package org.example.daimasuixianglu.haxibiao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description
 * @date 2024/1/2 16:19:35
 */
public class leet350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], map.getOrDefault(nums1[i], 0) + 1);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (map.containsKey(nums2[i])) {
                if (map.get(nums2[i]) > 0) {
                    result.add(nums2[i]);
                    map.put(nums2[i], map.getOrDefault(nums2[i], 0) - 1);
                }
            }
        }
        return result.stream().mapToInt(x -> x).toArray();
    }
}
