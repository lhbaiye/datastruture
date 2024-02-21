package org.example.daimasuixianglu.dandiaozhan;

import org.junit.Test;

import java.util.Stack;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description
 * @date 2024/1/19 14:57:34
 */
public class leet84 {

    @Test
    public void test() {
        largestRectangleArea(new int[] {2, 1, 5, 6, 2, 3});
    }

    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<Integer>();

        // 数组扩容，在头和尾各加入一个元素
        int [] newHeights = new int[heights.length + 2];
        newHeights[0] = 0;
        newHeights[newHeights.length - 1] = 0;
        for (int index = 0; index < heights.length; index++){
            newHeights[index + 1] = heights[index];
        }
        heights = newHeights;
        st.push(0);
        int result = 0;
        for (int i = 1; i < heights.length; i++) {
            if (heights[i] > heights[st.peek()]) {
                st.push(i);
            } else if (heights[i] == heights[st.peek()]) {
                st.pop(); // 这个可以加，可以不加，效果一样，思路不同
                st.push(i);
            } else {
                while (heights[i] < heights[st.peek()]) { // 注意是while
                    int mid = st.peek();
                    st.pop();
                    int left = st.peek();
                    int right = i ;
                    int w = right - left - 1;
                    int h = heights[mid];
                    result = Math.max(result, w * h);
                }
                st.push(i);
            }
        }
        return result;
    }
}
