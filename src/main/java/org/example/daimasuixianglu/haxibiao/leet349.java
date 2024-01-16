package org.example.daimasuixianglu.haxibiao;

import java.util.HashSet;
import java.util.Set;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description 给定两个数组，编写一个函数来计算它们的交集。
 * @date 2024/1/1 20:30:38
 */
public class leet349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> resSet = new HashSet<>();
        //遍历数组1
        for (int i : nums1) {
            set1.add(i);
        }
        //遍历数组2的过程中判断哈希表中是否存在该元素
        for (int i : nums2) {
            if (set1.contains(i)) {
                resSet.add(i);
            }
        }

        //方法1：将结果集合转为数组

        return resSet.stream().mapToInt(x -> x).toArray();
    }
}
