package org.example.daimasuixianglu.haxibiao;

import java.util.HashSet;
import java.util.Set;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description
 * @date 2024/1/2 16:26:42
 */
public class leet202 {
    public static void main(String[] args) {
        leet202 leet202 = new leet202();
        System.out.println(leet202.isHappy(2));
    }
    public boolean isHappy(int n) {
        Set<Integer> record = new HashSet<>();
        while (n != 1 && !record.contains(n)) {
            record.add(n);
            n = calNum(n);
        }
        return n == 1;
    }

    public int calNum(int n) {
        // 计算n
        int result = 0;
        while (n > 0) {
            result+= (n % 10) * (n % 10);
            n = n / 10;
        }
        return result;
    }
}
