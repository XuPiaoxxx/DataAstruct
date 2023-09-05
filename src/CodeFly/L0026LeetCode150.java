package CodeFly;

import java.util.Stack;

/**
 * L0025LeetCode1047-LeetCode:150-代码随想录
 * 2023.09.05/11.17

 题目:给你一个字符串数组 tokens ，表示一个根据 逆波兰表示法 表示的算术
 表达式。请你计算该表达式。返回一个表示表达式值的整数。
*样例:
 *
 * tips:逆波兰式，借助一个辅助栈实现。
 *       优化switch-case替换if-else
 *       foreach增强
 *       parseInt替换valueOf减少自动装箱
 *       可以借助数组实现
 *
*/

public class L0026LeetCode150 {
    public static void main(String[] args) {
    }
    //参考了答案，以后自己用栈实现，理解一下。
    public static int evalRPN1(String[] tokens) {
        Stack<Integer> numbers=new Stack();
        for(String i:tokens){
            if(i.equals("+")||i.equals("-")||i.equals("*")||i.equals("/")){
                if(i.equals("+")) numbers.push(numbers.pop()+numbers.pop());
                else if(i.equals("-")){
                    int a=numbers.pop();
                    int b=numbers.pop();
                    numbers.push(b-a);
                }
                else if(i.equals("*")) numbers.push(numbers.pop()*numbers.pop());
                else if(i.equals("/")){
                    int a=numbers.pop();
                    int b=numbers.pop();
                    numbers.push(b/a);
                    }
                } else{
                numbers.push(Integer.parseInt(i));
            }
        }
        return numbers.peek();
    }
    //优化后，参考大佬
    public int evalRPN2(String[] tokens) {
        Stack<Integer> numStack = new Stack<>();
        Integer op1, op2;
        for (String s : tokens) {
            switch (s) {
                case "+":
                    op2 = numStack.pop();
                    op1 = numStack.pop();
                    numStack.push(op1 + op2);
                    break;
                case "-":
                    op2 = numStack.pop();
                    op1 = numStack.pop();
                    numStack.push(op1 - op2);
                    break;
                case "*":
                    op2 = numStack.pop();
                    op1 = numStack.pop();
                    numStack.push(op1 * op2);
                    break;
                case "/":
                    op2 = numStack.pop();
                    op1 = numStack.pop();
                    numStack.push(op1 / op2);
                    break;
                default:
                    numStack.push(Integer.valueOf(s));
                    break;
            }
        }
        return numStack.pop();
    }
    //数组实现，参考大佬
    public int evalRPN3(String[] tokens) {
        Stack<Integer> numStack = new Stack<>();
        Integer op1, op2;
        for (String s : tokens) {
            switch (s) {
                case "+":
                    op2 = numStack.pop();
                    op1 = numStack.pop();
                    numStack.push(op1 + op2);
                    break;
                case "-":
                    op2 = numStack.pop();
                    op1 = numStack.pop();
                    numStack.push(op1 - op2);
                    break;
                case "*":
                    op2 = numStack.pop();
                    op1 = numStack.pop();
                    numStack.push(op1 * op2);
                    break;
                case "/":
                    op2 = numStack.pop();
                    op1 = numStack.pop();
                    numStack.push(op1 / op2);
                    break;
                default:
                    numStack.push(Integer.valueOf(s));
                    break;
            }
        }
        return numStack.pop();
    }
}
