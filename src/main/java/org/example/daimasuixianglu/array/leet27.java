package org.example.daimasuixianglu.array;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description
 * @date 2023/12/31 22:06:04
 */
public class leet27 {
    public int removeElement(int[] nums, int val) {
        int l = 0, r = 0;
        for (;r < nums.length; r++) {
            if (nums[r] != val) {
                nums[l++] = nums[r];
            }
        }
        return l;
    }

    public int removeElement2(int[] nums, int val) {
        //双向双指针
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            // 找坐标等于的，替换掉右边不等于得到
            while (l <= r && nums[l] != val) {
                l++;
            }
            while (l <= r && nums[r] == val) {
                r--;
            }
            // 交换
            if (l < r) {
                nums[l++] = nums[r--];
            }
        }
        return l;
    }
}
