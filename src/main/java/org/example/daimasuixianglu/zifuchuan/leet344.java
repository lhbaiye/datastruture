package org.example.daimasuixianglu.zifuchuan;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description
 * @date 2024/1/2 20:59:36
 */
public class leet344 {
    public void reverseString(char[] s) {
        int l = 0, r = s.length;
        while (l <= r - 1) {
            char temp = s[l];
            s[l] = s[r];
            s[r] = temp;
            l++;
            r--;
        }
    }
}
