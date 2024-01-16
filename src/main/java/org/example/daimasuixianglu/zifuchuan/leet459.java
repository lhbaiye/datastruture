package org.example.daimasuixianglu.zifuchuan;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description
 * @date 2024/1/3 15:16:23
 */
public class leet459 {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        for (int i = 1; 2 * i <= n; i++) {
            if (n % i == 0) {
                boolean match = true;
                for (int j = i; j < n; j++) {
                    if (s.charAt(j) != s.charAt(j - i)) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    return true;
                }
            }
        }
        return false;
    }
}
