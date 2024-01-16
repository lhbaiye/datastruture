package org.example.leetcode.huadongchuangkou;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度
 * @date 2023/12/24 21:50:56
 */
public class leet3 {

    public static void main(String[] args) {
        leet3 leet3 = new leet3();
        System.out.println(leet3.lengthOfLongestSubstring("eidbaooo"));

    }
    public int lengthOfLongestSubstring(String s) {
        // 维护一个map。存放如果该字符串不存在，则右移动，如果存在则左移动
        Map<Character, Integer> ori = new HashMap<Character, Integer>();
        int sLen = s.length();
        int r = 0, l = 0, maxLen = Integer.MIN_VALUE;
        while (r < sLen){
            if (ori.containsKey(s.charAt(r))) {
                l = Math.max(l, ori.get(s.charAt(r)) + 1);
            }
            ori.put(s.charAt(r), r);
            maxLen = Math.max(maxLen, r - l + 1);
            r++;
        }
        return maxLen;
    }
}
