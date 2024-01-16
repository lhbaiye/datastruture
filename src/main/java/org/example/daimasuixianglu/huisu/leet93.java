package org.example.daimasuixianglu.huisu;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description
 * @date 2024/1/9 20:40:14
 */
public class leet93 {

    @Test
    public void test() {
        restoreIpAddresses("25525511135");
    }

//    public List<String> restoreIpAddresses(String s) {
//        List<String> result = new ArrayList<>();
//        StringBuilder sb = new StringBuilder(s);
//        backtracking(result, sb, 0, 0);
//        return result;
//    }
//
//    private void backtracking(List<String> result, StringBuilder sb, int index, int k) {
//        if (k == 3) {
//            if (isValid(sb, index, sb.length() - 1)) {
//                result.add(sb.toString());
//            }
//            return;
//        }
//        for (int i = index; i < sb.length(); i++) {
//            if (isValid(sb, index, i)) {
//                sb.insert(i + 1, '.');
//                backtracking(result, sb, i + 2, k + 1);
//                sb.deleteCharAt(i + 1);
//            }
//        }
//
//    }
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        List<String> temp = new ArrayList();
        backtracking(s, result, temp, 0, 4);
        return result;
    }

    private void backtracking(String s, List<String> result, List<String> temp, int index, int segNum) {
        if (segNum == 0) {
            if (index == s.length()) {
                result.add(String.join(".", temp));
            }
            return;
        }
        for (int i = index; i < s.length() && i < index + 3; i++) {
            if (isValid(s, index, i)) {
                temp.add(s.substring(index, i + 1));
                backtracking(s, result, temp, i + 1, segNum - 1);
                temp.remove(temp.size() - 1);
            }
        }
    }


    private boolean isValid(String s, int start, int end){
        if(start > end)
            return false;
        if(s.charAt(start) == '0' && start != end)
            return false;
        int num = 0;
        for(int i = start; i <= end; i++){
            int digit = s.charAt(i) - '0';
            num = num * 10 + digit;
            if(num > 255)
                return false;
        }
        return true;
    }
}
