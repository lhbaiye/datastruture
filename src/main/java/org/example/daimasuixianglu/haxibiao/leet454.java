package org.example.daimasuixianglu.haxibiao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description
 * @date 2024/1/2 17:03:13
 */
public class leet454 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int res = 0;
        ArrayList<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        /**
         * 计算前三个数组中，有多少数字
         */
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                map.put(nums1[i] + nums2[j], map.getOrDefault(nums1[i] + nums2[j], 0) + 1);
            }
        }
        //统计剩余的两个元素的和，在map中找是否存在相加为0的情况，同时记录次数
        for (int i : nums3) {
            for (int j : nums4) {
                res += map.getOrDefault(0 - i - j, 0);
            }
        }
        return res;
    }

}
