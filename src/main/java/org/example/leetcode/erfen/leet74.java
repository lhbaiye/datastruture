package org.example.leetcode.erfen;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description
 * @date 2023/12/25 14:55:32
 */
public class leet74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        // 思路：将2维数组转为1维数组 进行二分搜索
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int left = 0;
        int right = row * col - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            int val = matrix[mid/col][mid%col];
            if (val == target) {
                return true;
            } else if (target < val) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (matrix[left/col][left%col] == target || matrix[right/col][right%col] == target) {
            return true;
        }
        return false;
    }
}
