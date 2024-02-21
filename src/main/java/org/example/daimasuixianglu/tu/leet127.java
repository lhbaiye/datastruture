package org.example.daimasuixianglu.tu;

import java.util.*;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description
 * @date 2024/1/20 15:41:51
 */
public class leet127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> wordSet = new HashSet<>(wordList);
        if (wordSet.size() == 0 || !wordSet.contains(endWord)) {
            return 0;
        }
        Queue<String> queue = new LinkedList<>(); //bfs 队列
        queue.offer(beginWord);
        Map<String, Integer> map = new HashMap<>(); //记录单词对应路径长度
        map.put(beginWord, 1);
        while (!queue.isEmpty()) {
            String word = queue.poll();
            int path = map.get(word);
            //遍历单词的每个字符
            for (int i = 0; i < word.length(); i++) {
                char[] chars = word.toCharArray();
                for (char k = 'a'; k <= 'z'; k++) {
                    chars[i] = k;
                    String newWord = String.valueOf(chars); //得到新的字符串
                    if (newWord.equals(endWord)) {
                        return path + 1;
                    }
                    //如果新单词在set中，但是没有访问过
                    if (wordSet.contains(newWord) && !map.containsKey(newWord)) {
                        map.put(newWord, path + 1); //记录单词对应的路径长度
                        queue.offer(newWord);
                    }
                }
            }
        }
        return 0;
    }
}
