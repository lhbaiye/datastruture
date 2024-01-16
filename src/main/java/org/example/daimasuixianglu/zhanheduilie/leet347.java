package org.example.daimasuixianglu.zhanheduilie;

import java.util.*;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description
 * @date 2024/1/5 14:32:52
 */
public class leet347 {
    public static void main(String[] args) {
        leet347 leet347 = new leet347();
        leet347.topKFrequent(new int[]{1,1,1,2,2,3}, 2);
    }
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] pair1, int[] pair2) {
                return pair2[1] - pair1[1];
            }
        });
        for (Integer key : map.keySet()) {
            Integer value = map.get(key);
            pq.offer(new int[]{key, value});
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = pq.poll()[0];
        }
        return result;

    }
}
