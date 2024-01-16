package org.example.daimasuixianglu.tanxin;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description
 * @date 2024/1/13 21:47:34
 */
public class leet1005 {
    public int largestSumAfterKNegations(int[] nums, int k) {
        nums = IntStream.of(nums).boxed()
                .sorted((o1, o2) -> Math.abs(o2) - Math.abs(o1))
                .mapToInt(Integer::intValue).toArray();
        int len = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0 && k > 0) {
                nums[i] = -nums[i];
                k--;
            }
        }
        if (k % 2 == 1) {
            nums[len - 1] = -nums[len - 1];
        }
        return Arrays.stream(nums).sum();
    }
}
