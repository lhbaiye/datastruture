package org.example.daimasuixianglu.dandiaozhan;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description
 * @date 2024/1/19 14:21:51
 */
public class leet739 {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> deque = new LinkedList<>();
        int[] result = new int[temperatures.length];
        deque.push(0);
        for (int i = 1; i < temperatures.length; i++) {
            if (temperatures[i] <= temperatures[deque.peek()]) {
                deque.push(i);
            } else {
                while (!deque.isEmpty() && temperatures[i] > temperatures[deque.peek()]) {
                    result[deque.peek()] = i - deque.peek();
                    deque.poll();
                }
                deque.push(i);
            }
        }
        return result;
    }
}
