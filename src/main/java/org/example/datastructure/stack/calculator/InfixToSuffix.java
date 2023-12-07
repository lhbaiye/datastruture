package org.example.datastructure.stack.calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description 中缀表达式转为后缀
 * @date 2023/12/7 23:19:17
 */
public class InfixToSuffix {
    public static void main(String[] args) {

    }

    /**
     * 将中缀表达式解析成单个元素的 List，
     *
     * @param infixExpression
     * @return 1+((2+3)*4)-5 -> [1,+,(,(,2,+,3,),*,4,),5]
     */
    public List<String> infix2List(String infixExpression) {
        ArrayList<String> res = new ArrayList<>();
        // 扫描并且解析
        int index= 0;
        char ch = 0;
        String tempNum = ""; // 支持多位数
        while (index < infixExpression.length()) {
            ch = infixExpression.charAt(index++);
            // 如果不是数字，直接添加到容器
            if (!(ch >= 48 && ch <= 57)) {
                // 如果拼接的多位数还有值，则添加到容器中
                if (!tempNum.isEmpty()) {
                    res.add(tempNum);
                    tempNum = "";
                }
                res.add(ch + "");
                continue;
            }
            // 如果是数字，需要考虑多位数
            tempNum+=ch;
            if (index == infixExpression.length()) {
                res.add(tempNum);
                tempNum = "";
            }
        }
        return res;
    }

    /**
     * 中缀表达式 List 转为后缀表达式 List
     *
     * @param infixList
     * @return
     */
    private ArrayList<String> infixList2SuffixList(List<String> infixList) {
        Stack<String> s1 = new Stack<>();
        // 用栈来存储元素，只需要入栈，不需要出栈
        ArrayList<String> s2 = new ArrayList<>();
        for (String item : infixList) {
            if (item.matches("\\d+")) {
                s2.add(item);
            }
            // 如果是左括号，需要加入到栈中
            if (item.equals("(")) {
                s1.push(item);
            }
            //如果是右括号， 需要依次弹出栈中的运算符，知道匹配到左括号
            if (item.equals(")")) {
                while (!s1.peek().equals("(")) {
                    s2.add(s1.pop());
                }
                // 上面循环完，丢到这个(
                s1.pop();
            }
            // 如果是运算符
            // 如果 s1 为空，或则栈顶运算符为 （，则压入符号栈 s1
            // 如果优先级比栈顶运算符 高，则压入符号栈 s1,否则，否则将 s1 栈顶的运算符弹出，压入 s2 中
            // 上面两句话，转换成下面的描述
            // 上面如果  s1 栈顶符号优先级比 当前符号高，则弹出加入到 s2 中。
            // 因为：如果栈顶符号是 （ 返回优先级为 -1.比当前符号低，则不会走该方法
            while (!s1.empty() && priority(s1.peek().charAt(0)) >= priority(item.charAt(0))) {
                s2.add(s1.pop());
            }
            s1.push(item);
        }
        // 将 s1 中的运算符依次弹出并加入 s2 中
        while (!s1.isEmpty()) {
            s2.add(s1.pop());
        }
        return s2;
    }

    /**
     * 计算符号的优先级
     */
    private int priority(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 0;
            case '*':
            case '/':
                return 1;
            default:
                return -1;
        }
    }
}
