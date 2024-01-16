package org.example.leetcode.huadongchuangkou;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description
 * @date 2023/12/24 23:05:23
 */
public class leet438 {
    public static void main(String[] args) {
        leet438 leet438 = new leet438();
        System.out.println(leet438.findAnagrams("cbaebabacd", "abc"));
    }
    public List<Integer> findAnagrams(String s, String p) {
        int pLen = p.length();
        Map<Character, Integer> ori = new HashMap<Character, Integer>();
        Map<Character, Integer> cnt = new HashMap<Character, Integer>();
        // 初始化p中所有的字符都要出现
        for (int i = 0; i < pLen; i++) {
            ori.put(p.charAt(i), ori.getOrDefault(p.charAt(i), 0) + 1);
        }
        int charNum = ori.keySet().size();
        int match = 0;
        int l = 0, r = 0;
        int sLen = s.length();
        ArrayList<Integer> result = new ArrayList<>();
        while (r < sLen) {
            // 右指针往右移动，如果当前这个元素
            if (ori.containsKey(s.charAt(r))) {
                cnt.put(s.charAt(r), cnt.getOrDefault(s.charAt(r), 0) + 1);
                if (ori.get(s.charAt(r)).equals(cnt.get(s.charAt(r)))) {
                    match++;
                }
            }
            r++;
            while (l <= r && match == charNum) {
                // 加入答案中
                // l 往右移动
                if (ori.containsKey(s.charAt(l))) {
                    cnt.put(s.charAt(l), cnt.getOrDefault(s.charAt(l), 0) - 1);
                    if (cnt.get(s.charAt(l)) < ori.get(s.charAt(l))) {
                        match--;
                    }
                }
                if (r - l == p.length()) {
                    result.add(l);
                }
                l++;
            }
        }
        return result;
    }
}
