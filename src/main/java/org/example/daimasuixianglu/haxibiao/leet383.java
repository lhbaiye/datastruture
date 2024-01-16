package org.example.daimasuixianglu.haxibiao;

import java.util.HashMap;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description
 * @date 2024/1/2 18:26:44
 */
public class leet383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            map.put(magazine.charAt(i), map.getOrDefault(magazine.charAt(i), 0) + 1);
        }
        boolean result = true;
        for (int i = 0; i < ransomNote.length(); i++) {
            if (map.containsKey(ransomNote.charAt(i))) {
                if (map.get(ransomNote.charAt(i)) > 0) {
                    map.put(ransomNote.charAt(i), map.getOrDefault(ransomNote.charAt(i), 0) - 1);
                } else {
                    return false;
                }

            } else {
                return false;
            }
        }
        return result;
    }
}
