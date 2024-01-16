package org.example.daimasuixianglu.zifuchuan;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description
 * @date 2024/1/3 14:50:53
 */
public class leet28 {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        for (int i = 0; i < haystack.length(); i++) {
            int j=0;
            int k = i;
            for (; j < needle.length(); j++){
                if(k >= haystack.length()){
                    return -1;
                }
                if (needle.charAt(j) != haystack.charAt(k)){
                    break;
                }else {
                    k++;
                }
            }
            if (j == needle.length()){
                return i;
            }
        }
        return -1;
    }
}
