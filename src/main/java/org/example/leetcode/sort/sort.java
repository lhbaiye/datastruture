package org.example.leetcode.sort;

import java.util.Arrays;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description
 * @date 2023/12/25 18:19:53
 */
public class sort {
    public static void main(String[] args) {
        sort sort = new sort();
        int[] nums = {1,3,4,56,2,90,67};
//        sort.quickSort(nums);
        sort.mergeSort(nums);
        Arrays.stream(nums).forEach(item -> System.out.println(item));
    }
    public void quickSort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    private void quickSort(int[] nums, int left, int right) {
        // 先确定一个基准值
        int pivot = left + (right - left) / 2;
        int l = left, r = right;
        int val = nums[pivot];
        while (l < r) {
            while (nums[l] < val) {
                l++;
            }
            while (nums[r] > val) {
                r--;
            }
            // 交换
            if (l > r) {
                break;
            }
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            // 交换玩以后，l
            l++;
            r--;
        }
        if (l == r) {
            l++;
            r--;
        }
        if (left < r) {
            quickSort(nums, left, r);
        }
        if (right > l) {
            quickSort(nums, l, right);
        }


    }

    public void mergeSort(int[] nums) {
        int[] temp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1, temp);
    }

    public void mergeSort(int[] nums, int left, int right, int[] temp) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        //先分
        mergeSort(nums, left, mid, temp);
        mergeSort(nums, mid + 1, right, temp);
        merge(nums, left, mid, right, temp);

    }

    private void merge(int[] nums, int left, int mid, int right, int[] temp) {
        // 开始合并
        int l = left;
        int r = mid + 1;
        int t = 0;
        while (l < mid && r < right) {
            if (nums[l] < nums[r]) {
                temp[t] = nums[l];
                l++;
            } else {
                temp[t] = nums[r];
                r++;
            }
            t++;
        }
        // 2. 如果有任意一边的数组还有值，则依序将剩余数据填充到 temp 中
        // 如果左侧还有值
        while (l <= mid) {
            temp[t++] = nums[l++];
        }
        // 如果右侧还有值
        while (r <= right) {
            temp[t++] = nums[r++];
        }

        // 放回去
        t = 0;
        int tempL = left;;
        while (tempL <= right) {
            nums[tempL] = temp[t];
            tempL++;
            t++;
        }

    }


}
