package CodeFly;

import java.util.Stack;

/**
 * L0025LeetCode1047-LeetCode:150-��������¼
 * 2023.09.05/11.17

 ��Ŀ:����һ���ַ������� tokens ����ʾһ������ �沨����ʾ�� ��ʾ������
 ���ʽ���������ñ��ʽ������һ����ʾ���ʽֵ��������
*����:
 *
 * tips:�沨��ʽ������һ������ջʵ�֡�
 *       �Ż�switch-case�滻if-else
 *       foreach��ǿ
 *       parseInt�滻valueOf�����Զ�װ��
 *       ���Խ�������ʵ��
 *
*/

public class L0026LeetCode150 {
    public static void main(String[] args) {
    }
    //�ο��˴𰸣��Ժ��Լ���ջʵ�֣����һ�¡�
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
    //�Ż��󣬲ο�����
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
    //����ʵ�֣��ο�����
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
