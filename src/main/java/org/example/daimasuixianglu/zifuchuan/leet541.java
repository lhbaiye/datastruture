package org.example.daimasuixianglu.zifuchuan;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description
 * @date 2024/1/2 21:50:20
 */
public class leet541 {
    public String reverseStr(String s, int k) {
        char[] ch = s.toCharArray();
        for (int i = 0; i < s.length(); i+=2 * k) {
            int l = i;
            //这里是判断尾数够不够k个来取决end指针的位置
            int r = Math.min(ch.length - 1, l + k - 1);
            char[] array = s.substring(l, r + 1).toCharArray();
            while (l <= r) {
                char temp = ch[l];
                ch[l] = ch[r];
                ch[r] = temp;
                l++;
                r--;
            }
        }
        return new String(ch);
    }
}
