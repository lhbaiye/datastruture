package org.example.daimasuixianglu.haxibiao;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * @date 2024/1/1 20:23:12
 */
public class leet242 {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> sMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) + 1);
        }
        char[] array = t.toCharArray();
        for (int i = 0; i < array.length; i++) {
            if (sMap.containsKey(array[i])) {
                if (sMap.get(array[i]) <= 0) {
                    return false;
                } else {
                    sMap.put(array[i], sMap.get(array[i]) - 1);
                }
            } else {
                return false;
            }
        }
        AtomicBoolean res = new AtomicBoolean(true);
        sMap.forEach((key, value) -> {
            if (value != 0) {
                res.set(false);
            }
        });
        return res.get();
    }
}
