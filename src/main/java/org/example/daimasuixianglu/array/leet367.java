package org.example.daimasuixianglu.array;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description
 * @date 2023/12/31 21:47:41
 */
public class leet367 {
    public boolean isPerfectSquare(int num) {
        if (num == 1) {
            return true;
        }
        int l = 0, r = num - 1;
        while (l < r - 1) {
            int mid = l + (r - l) / 2;
            long res = (long) mid * mid;
            if (res == num) {
                return true;
            } else if (res < num) {
                l = mid;
            } else {
                r = mid;
            }
        }
        if ((long) r * r == num) {
            return true;
        } else if ((long) l * l == num){
            return true;
        } else {
            return false;
        }
    }
}
