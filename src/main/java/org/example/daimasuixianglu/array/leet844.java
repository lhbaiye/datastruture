package org.example.daimasuixianglu.array;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description
 * @date 2023/12/31 22:38:09
 */
public class leet844 {
    public static void main(String[] args) {
        leet844 leet844 = new leet844();
        System.out.println(leet844.backspaceCompare("ab##", "c#d#"));
    }
    public boolean backspaceCompare(String s, String t) {
        return build(s).equals(build(t));
    }

    public String build(String str) {
        int length = str.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            if (str.charAt(i) == '#') {
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            } else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

    public boolean backspaceCompare2(String s, String t) {
        int sLen = s.length() - 1;
        int tLen = t.length() - 1;
        int skipS = 0, skipT = 0;
        while (sLen >= 0 || tLen >= 0) {
            while (sLen >= 0) {
                if (s.charAt(sLen) == '#') {
                    skipS++;
                    sLen--;
                } else if (skipS > 0){
                    skipS--;
                    sLen--;
                } else {
                    break;
                }
            }
            while (tLen >= 0) {
                if (t.charAt(tLen) == '#') {
                    skipT++;
                    tLen--;
                } else if (skipT > 0) {
                    skipT--;
                    tLen--;
                } else {
                    break;
                }
            }

            if (sLen >= 0 && tLen >= 0) {
                if (s.charAt(sLen) != t.charAt(tLen)) {
                    return false;
                }
            } else {
                if (sLen >= 0 || tLen >= 0) {
                    return false;
                }
            }
            sLen--;
            tLen--;
        }
        return true;
    }

}
