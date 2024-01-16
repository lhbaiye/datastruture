package org.example.daimasuixianglu.tanxin;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description
 * @date 2024/1/14 17:41:12
 */
public class leet860 {
    public boolean lemonadeChange(int[] bills) {
        int t1 = 0;
        int t2 = 0;
        int t3 = 0;
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                t1++;
            } else if (bills[i] == 10) {
                if (t1 == 0) {
                    return false;
                } else {
                    t1--;
                    t2++;
                }
            } else {
                if (t1 >= 1 && t2 >= 1) {
                    t1-=1;
                    t2-=1;
                    t3++;
                } else if (t1 >=3){
                    t1-=3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
