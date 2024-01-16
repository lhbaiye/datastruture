package org.example.daimasuixianglu.zhanheduilie;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description
 * @date 2024/1/5 13:04:39
 */
public class leet1047 {
    public static void main(String[] args) {
        leet1047 leet1047 = new leet1047();
        leet1047.removeDuplicates("abbaca");
    }
    public String removeDuplicates(String s) {
        char[] array = s.toCharArray();
        int fast = 0, slow = 0;
        while (fast < s.length()) {
            array[slow] = array[fast];
            if (slow > 0 && array[slow] == array[slow - 1]) {
                slow--;
            } else {
                slow++;
            }
            fast++;
        }
        return new String(array, 0, slow);
    }
}
