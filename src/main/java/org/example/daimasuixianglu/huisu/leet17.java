package org.example.daimasuixianglu.huisu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description
 * @date 2024/1/9 15:33:25
 */
public class leet17 {

    private final static Map<Character, String> map = new HashMap<>();
    static {
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }

    public List<String> letterCombinations(String digits) {
        StringBuilder builder = new StringBuilder();
        List<String> result = new ArrayList<>();
        backtrack(digits, 0, builder, result);
        return result;
    }

    private void backtrack(String digits, int pos, StringBuilder builder, List<String> result) {
        if (builder.length() == digits.length()) {
            if (pos == 0) {
                return;
            }
            result.add(builder.toString());
            return;
        }
        for (char c : map.get(digits.charAt(pos)).toCharArray()) {
            builder.append(c);
            backtrack(digits, pos + 1, builder, result);
            builder.deleteCharAt(builder.length() - 1);
        }
    }
}
