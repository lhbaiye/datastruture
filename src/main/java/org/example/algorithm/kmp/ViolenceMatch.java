package org.example.algorithm.kmp;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description 暴力匹配
 * @date 2023/12/13 20:06:54
 */
public class ViolenceMatch {
    /**
     * 暴力匹配
     *
     * @param str1 要匹配的文本  adf
     * @param str2 关键词 adacadf
     * @return
     */
    public int violenceMatch(String str1, String str2) {
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();
        int s1Len = s1.length;
        int s2Len = s2.length;
        int i = 0; //指向s1正在匹配位置
        int j = 0; //指向s2正在匹配位置
        while (i < s1Len && j < s2Len) {
            // 如果相等，则两个指针一起移动
            if (s1[i] == s2[j]) {
                i++;
                j++;
            } else {
                i = i - (j - 1);
                j = 0;
            }
        }
        if (j == s2Len) {
            // 返回匹配开始的字符
            return i - j;
        }
        return -1;
    }
}
