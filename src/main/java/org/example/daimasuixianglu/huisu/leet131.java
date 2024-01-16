package org.example.daimasuixianglu.huisu;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description
 * @date 2024/1/9 20:13:54
 */
public class leet131 {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        backtracking(s, result, temp, 0);
        return result;
    }

    private void backtracking(String s, List<List<String>> result, List<String> temp, int index) {
        if (index == s.length()) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            if (isPrim(s.substring(index, i + 1))) {
                temp.add(s.substring(index, i + 1));
            } else {
                continue;
            }
            backtracking(s, result, temp, i + 1);
            temp.remove(temp.size() - 1);
        }

    }


    private boolean isPrim(String str) {
        for (int i = 0, j = str.length() - 1; i < j; i++, j--) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
