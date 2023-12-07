package org.example.datastructure.stack.calculator;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description 计算器代码
 * @date 2023/12/7 21:46:39
 */
public class Calculator {
    // 使用前面的模拟栈
    private ArrayStack numStack = new ArrayStack(10);
    private ArrayStack operStack = new ArrayStack(10);

    public static void main(String[] args) {

    }

    public void scan(String expression) {
        int index = 0;
        String keepNum = "";
        while (true) {
            if (index == expression.length()) {
                break;
            }
            char ch = expression.substring(index, ++index).charAt(0);
            if (isOper(ch)) {
                if (operStack.isEmpty()) {
                    operStack.push(ch);
                    continue;
                }
                // 操作符的优先级大于栈顶
                if (priority(ch) > priority((char) operStack.peek())) {
                    operStack.push(ch);
                    continue;
                }
                //小于，将栈顶取出
                int num1 = numStack.pop();
                int num2 = numStack.pop();
                int opre = operStack.pop();
                int res = cal(num1, num2, opre);
                // 将结果入数栈
                numStack.push(res);
                // 将当期操作符入符号栈
                operStack.push(ch);
            } else {
//                numStack.push(Integer.valueOf(ch));
                keepNum+=ch;
                if (index == expression.length()) {
                    numStack.push(Integer.valueOf(keepNum));
                    continue;
                }
                char tempCh = expression.substring(index, index + 1).charAt(0);
                if (isOper(tempCh)) {
                    numStack.push(Integer.parseInt(keepNum));
                    keepNum = "";
                }

            }

        }
    }

    /**
     * 第 2 步：从栈中取出来数据和符号，然后计算
     *
     * @return
     */
    private int nextCal() {
        System.out.println("符号栈中符号情况：");
        operStack.print();
        while (true) {
            if (operStack.isEmpty()) {
                break;
            }
            int num1 = numStack.pop();
            int num2 = numStack.pop();
            int oper = operStack.pop();
            int res = cal(num1, num2, oper);
            // 将结果入数栈
            numStack.push(res);
        }
        // 计算完成之后，数栈中只有一个数据了，就是结果
        System.out.println("栈中数据是否只有一个结果数字：");
        numStack.print();
        return numStack.pop();
    }

    /**
     * 是否是操作符
     *
     * @param ch
     * @return
     */
    private boolean isOper(char ch) {
        switch (ch) {
            case '+':
            case '-':
            case '*':
            case '/':
                return true;
        }
        return false;
    }

    /**
     * 计算操作符号优先级，暂时只支持 + - * /
     *
     * @param ch
     * @return 优先级越高，数值越大
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

    /**
     * 计算
     *
     * @param num1 依次从栈顶弹出来的数据
     * @param num2
     * @param oper 操作符
     * @return
     */
    private int cal(int num1, int num2, int oper) {
        switch (oper) {
            case '+':
                return num1 + num2;
            case '-':
                // 注意顺序，在栈底的数据，是先进去的，如果是减法，则是前面的数字减后面的数字
                return num2 - num1;
            case '*':
                return num1 * num2;
            case '/':
                return num2 / num1;
        }
        // 由于前面校验过操作符，不会走到这里来的
        return 0;
    }
}
