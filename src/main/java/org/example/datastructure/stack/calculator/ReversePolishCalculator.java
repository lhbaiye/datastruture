package org.example.datastructure.stack.calculator;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description
 * @date 2023/12/7 23:07:32
 */
public class ReversePolishCalculator {
    public static void main(String[] args) {

    }

    public List<String> convert(String postfixExpression) {
        return Arrays.asList(postfixExpression.split(" "));
    }

    /**
     * 计算一个后缀表达式的值
     *
     * @param postfixExpression
     * @return
     */
    public int cal(String postfixExpression) {
        return start(convert(postfixExpression));
    }

    private int start(List<String> postfixElements) {
        /*
        比如：`(3+4)x5-6` 对应的后缀表达式 `3 4 + 5 x 6 -`
        1. 从左到右扫描，将 3、4 压入堆栈
        2. 扫描到 `+` 运算符时
        将弹出 4 和 3，计算 `3 + 4 = 7`，将 7 压入栈
        3. 将 5 入栈
        4. 扫描到 `x` 运算符时
        将弹出 5 和 7 ，计算 `7 x 5 = 35`，将 35 入栈
        5. 将 6 入栈
        6. 扫描到 `-` 运算符时
        将弹出 6 和 35，计算 `35 - 6 = 29`，将 29 压入栈
        7. 扫描表达式结束，29 是表达式的值
                */
        Stack<Integer> stack = new Stack<>();
        for (String el : postfixElements) {
            if (el.matches("\\d+")) {
                stack.push(Integer.parseInt(el));
                continue;
            }
            // 是运算符 推出两个数
            Integer num2 = stack.pop();
            Integer num1 = stack.pop();
            int res = cal(num1, num2, el.charAt(0));
            stack.push(res);
        }
        return stack.pop();
    }


    /**
     * 计算
     *
     * @param num1
     * @param num2
     * @param oper 操作符
     * @return
     */
    private int cal(int num1, int num2, char oper) {
        switch (oper) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                return num1 / num2;
        }
        throw new IllegalArgumentException("不支持的运算符：" + oper);
    }
}
