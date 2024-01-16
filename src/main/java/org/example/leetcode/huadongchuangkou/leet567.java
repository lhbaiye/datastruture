package org.example.leetcode.huadongchuangkou;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description 给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。
 * @date 2023/12/24 21:17:36
 */
public class leet567 {
    Map<Character, Integer> ori = new HashMap<Character, Integer>();
    Map<Character, Integer> cnt = new HashMap<Character, Integer>();

    public static void main(String[] args) {
        leet567 leet567 = new leet567();
        System.out.println(leet567.checkInclusion("eidbaooo", "ab"));

    }

    public boolean checkInclusion(String s1, String s2) {
        // 只要次数匹配就可以
        int s2Len = s2.length();
        for (int i = 0; i < s2Len; i++) {
            ori.put(s2.charAt(i), ori.getOrDefault(s2.charAt(i), 0) + 1);
        }
        int charNum = ori.keySet().size();
        // 开始前进
        int l = 0, r = -1;
        int s1Len = s1.length();
        // 匹配数
        int match = 0;
        while (r < s1Len) {
            r++;
            //如果这个节点，在ori中那么需要加1
            if (r < s1Len && ori.containsKey(s1.charAt(r))) {
                cnt.put(s1.charAt(r), cnt.getOrDefault(s1.charAt(r), 0) + 1);
                if (ori.get(s1.charAt(r)) == cnt.get(s1.charAt(r))) {
                    match++;
                }
            }
            while (match == charNum) {
                if (r - l + 1 == s2.length()) {
                    return true;
                }
                char c = s1.charAt(l);
                if (ori.containsKey(c)) {
                    if (ori.get(c) == cnt.get(c)){
                        match--;
                    }
                    cnt.put(s1.charAt(l), cnt.getOrDefault(s1.charAt(l),0) - 1);
                }
                ++l;
            }
        }
        return false;
    }
}
